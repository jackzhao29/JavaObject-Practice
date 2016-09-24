package com.coldface.code.akka.rpc.client;

import java.util.concurrent.TimeUnit;

import com.coldface.code.akka.rpc.RpcEvent;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * 类RpcClienetActor.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2016年8月10日下午8:31:46
 */
public class RpcClientActor extends UntypedActor {
  
  private ActorRef rpc;

  public RpcClientActor(ActorRef rpc) {
      this.rpc = rpc;
  }

  /* (non-Javadoc)
   * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
   */
  @Override
  public void onReceive(Object message) throws Exception {
    // TODO Auto-generated method stub
    if (message instanceof RpcEvent.CallMethod) {
      Future<Object> future = Patterns.ask(rpc, message, new Timeout(
              Duration.create(10, TimeUnit.SECONDS)));
      Object o = Await.result(future,
              Duration.create(10, TimeUnit.SECONDS));
      getSender().tell(o, getSelf());
  }

  }

}
