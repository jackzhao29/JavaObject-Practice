package com.coldface.code.akka.dispatcher;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 类AkkaMain.java的实现描述：akka默认的Dispatcher
 * 
 * @author coldface
 * @date 2016年6月24日下午6:17:47
 */
public class AkkaMain {

    public static void main(String[] args) throws Exception {
        final ActorSystem system =
                ActorSystem.create("proinfo", ConfigFactory.load("dispatcher-application").getConfig("proinfo"));
        // 创建一个到greeter Actor的管道
        final ActorRef controlActor = system.actorOf(Props.create(ControlActor.class), "control");
        controlActor.tell(new StartCommand(100), ActorRef.noSender());
    }

}
