package com.coldface.code.akka.messagetype.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * 类TestConsumer.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年7月17日上午11:53:53
 */
public class TestConsumer {
  static final String topic = "test111";

  public static void main(String[] args) {
    Properties prop = new Properties();
    prop.put("zookeeper.connect", "localhost:2181");
    prop.put("serializer.class", "kafka.serializer.StringEncoder");
    prop.put("group.id", "group1");
    ConsumerConnector consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(prop));
    Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
    topicCountMap.put(topic, 1);
    Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams =
        consumer.createMessageStreams(topicCountMap);
    List<KafkaStream<byte[], byte[]>> streams = messageStreams.get(topic);
    System.out.println("streams.size={}" + streams.size());
    for (final KafkaStream<byte[], byte[]> stream : streams) {
      ConsumerIterator<byte[], byte[]> it = stream.iterator();
      while (it.hasNext()) {
        MessageAndMetadata<byte[], byte[]> mm = it.next();
        String message = new String(mm.message());
        System.out.println("message=" + message);
      }
    }
  }
}


