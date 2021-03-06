package com.coldface.code.akka.messagetype;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 类EventProcessorMain.java的实现描述：TODO Processor子系统的启动类
 * 
 * @author coldface
 * @date 2016年7月17日上午10:52:41
 */
public class EventProcessorMain {
  public static void main(String[] args) throws Exception {
    final String port = args.length > 0 ? args[0] : "0";

    final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
        .withFallback(ConfigFactory.parseString("akka.cluster.roles = [processor]"))
        .withFallback(ConfigFactory.load("cluster"));

    final ActorSystem system = ActorSystem.create("event-cluster-system", config);

    ActorRef processingActor =
        system.actorOf(Props.create(EventProcessor.class), "processingActor");

    system.log().info("Processing Actor: " + processingActor);
  }

}
