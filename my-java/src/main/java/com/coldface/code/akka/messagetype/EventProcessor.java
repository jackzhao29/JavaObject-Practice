package com.coldface.code.akka.messagetype;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.coldface.code.akka.messagetype.kafka.KafkaTemplate;

import akka.cluster.ClusterEvent;
import akka.cluster.Member;
import akka.cluster.MemberStatus;

/**
 * 类EventProcessor.java的实现描述：TODO Processor的实现
 * 
 * @author coldface
 * @date 2016年7月17日上午10:47:50
 */
public class EventProcessor extends ClusterRoleWorker {

  /* 内容的正则表达式 */
  private Pattern PATTERN = Pattern.compile("[\\?|&]([^=]+)=([^&]+)&");

  /* kafka的连接工具 */
  private KafkaTemplate kafkaTemplate = new KafkaTemplate("127.0.0.1:9092");

  @Override
  public void onReceive(Object message) throws Exception {
    if (message instanceof ClusterEvent.MemberUp) {
      ClusterEvent.MemberUp member = (ClusterEvent.MemberUp) message;
      log.info("Member is Up: {}", member.member().address());

      register(member.member(), getProcessorPath(member.member()));
    } else if (message instanceof ClusterEvent.CurrentClusterState) {

      ClusterEvent.CurrentClusterState state = (ClusterEvent.CurrentClusterState) message;
      Iterable<Member> members = state.getMembers();

      // 如果加入Akka集群的成员节点是Up状态，并且是collector角色，则调用register向collector进行注册
      for (Member member : members) {
        if (member.status() == MemberStatus.up()) {
          register(member, getProcessorPath(member));
        }
      }
    } else if (message instanceof ClusterEvent.UnreachableMember) {
      ClusterEvent.UnreachableMember mUnreachable = (ClusterEvent.UnreachableMember) message;
      log.info("Member detected as unreachable: {}", mUnreachable.member());
    } else if (message instanceof ClusterEvent.MemberRemoved) {
      ClusterEvent.MemberRemoved mRemoved = (ClusterEvent.MemberRemoved) message;
      log.info("Member is Removed: {}", mRemoved.member());
    } else if (message instanceof ClusterEvent.MemberEvent) {
      // ignore
      log.info("Member Event: {}", ((ClusterEvent.MemberEvent) message).member());
    } else if (message instanceof EventMessages.FilteredRecord) {
      EventMessages.FilteredRecord filteredRecord = (EventMessages.FilteredRecord) message;
      /* 处理每一行日志内容,转换成Map模型 */
      Map<String, String> data = process(filteredRecord.getEventCode(), filteredRecord.getLine(),
          filteredRecord.getLogDate(), filteredRecord.getRealIp());

      log.info("Processed: data=" + data);

      // 将解析后的消息一JSON字符串的格式，保存到Kafka中
      kafkaTemplate.convertAndSend(JSON.toJSONString(data));
    }
  }

  private Map<String, String> process(String eventCode, String line, String logDate,
      String realIp) {

    Map<String, String> data = new HashMap<String, String>();

    Matcher matcher = PATTERN.matcher(line);

    while (matcher.find()) {
      String key = matcher.group(1);
      String value = matcher.group(2);
      data.put(key, value);
    }

    data.put("eventdate", logDate);
    data.put("realip", realIp);

    return data;
  }

  private String getProcessorPath(Member member) {
    return member.address() + "/user/interceptingActor";
  }

}
