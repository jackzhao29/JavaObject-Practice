package com.coldface.code.akka.rpc.server;

import java.util.HashMap;
import java.util.Map;

import com.coldface.code.akka.rpc.ExampleInterface;
import com.coldface.code.akka.rpc.ExampleInterfaceImpl;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 类ServerMain.java的实现描述：TODO 服务端启动类
 * 
 * @author coldface
 * @date 2016年8月10日下午8:29:33
 */
public class ServerMain {
  public static void main(String[] args) {
    final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2551)
        .withFallback(ConfigFactory.parseString("akka.cluster.roles = [RpcServerActor]"))
        .withFallback(ConfigFactory.load());

    ActorSystem system = ActorSystem.create("EsbSystem", config);

    // Server 加入发布的服务
    Map<Class<?>, Object> beans = new HashMap<Class<?>, Object>();
    beans.put(ExampleInterface.class, new ExampleInterfaceImpl());
    system.actorOf(Props.create(RpcServerActor.class, beans), "RpcServerActor");
    System.out.println("服务端服务已发布...");
  }
}
