package com.coldface.code.akka.messagetype;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 类EventInterceptorMain.java的实现描述:Interceptor这个子系统的启动类
 * 
 * @author coldface
 * @date 2016年7月17日上午10:44:19
 */
public class EventInterceptorMain {

  public static void main(String[] args) {
    final String port = args.length > 0 ? args[0] : "0";

    /* 修改配置文件中的端口和角色 */
    final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
        .withFallback(ConfigFactory.parseString("akka.cluster.roles = [interceptor]"))
        .withFallback(ConfigFactory.load("cluster"));

    final ActorSystem system = ActorSystem.create("event-cluster-system", config);

    /* 实例化EventInterceptor Actor */
    ActorRef interceptingActor =
        system.actorOf(Props.create(EventInterceptor.class), "interceptingActor");

    system.log().info("Processing Actor: " + interceptingActor);
  }

}
