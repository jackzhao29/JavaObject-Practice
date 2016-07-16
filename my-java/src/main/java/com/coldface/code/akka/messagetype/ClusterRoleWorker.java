package com.coldface.code.akka.messagetype;


import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.Member;
import akka.event.Logging;
import akka.event.LoggingAdapter;


/**
 * 类ClusterRoleWorker.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年7月16日下午10:06:01
 */
public abstract class ClusterRoleWorker extends UntypedActor {

  // 记录日志
  protected LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  // 集群系统
  protected Cluster cluster = Cluster.get(getContext().system());

  // 用来缓存下游注册来的子系统ActorRef
  protected List<ActorRef> workers = new ArrayList<ActorRef>();

  @Override
  public void preStart() throws Exception {
    // 订阅集群事件
    cluster.unsubscribe(getSelf());

  }

  /**
   * 下游子系统节点发送注册消息
   * 
   * @date 2016年7月16日下午10:47:39
   * @param member
   * @param actorPath
   */
  protected void register(Member member, String actorPath) {
    ActorSelection actorSelection = getContext().actorSelection(actorPath);
    // 发送注册消息
    actorSelection.tell(new EventMessages.Registration(), getSelf());
  }
}
