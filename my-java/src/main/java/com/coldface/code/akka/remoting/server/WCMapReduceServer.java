package com.coldface.code.akka.remoting.server;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

/**
 * 类WCMapReduceServer.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date   2016年6月30日下午6:57:37
 */
public class WCMapReduceServer {
    
    private ActorRef mapRouter;
    private ActorRef reduceRouter;
    private ActorRef aggregateActor;
    private ActorRef wcMapReduceActor;
    
    public static void main(String[] args){
        new WCMapReduceServer(50, 50);
    }
    
    public WCMapReduceServer(int no_of_reduce_workers, int no_of_map_workers) {
        /*创建了Actor系统*/
        ActorSystem system = ActorSystem.create("WCMapReduceApp", ConfigFactory.load("remoting-server-application")
                .getConfig("WCMapReduceApp"));

        // 创建聚合Actor
        aggregateActor = system.actorOf(Props.create(AggregateActor.class));

        // 创建多个聚合的Actor
        reduceRouter = system.actorOf(Props.create(ReduceActor.class,aggregateActor).withRouter(new RoundRobinPool(no_of_reduce_workers)));

        // 创建多个Map的Actor
        mapRouter = system.actorOf(Props.create(MapActor.class,reduceRouter).withRouter(new RoundRobinPool(no_of_map_workers)));

        // create the overall WCMapReduce Actor that acts as the remote actor
        // for clients
        Props props = Props.create(WCMapReduceActor.class,aggregateActor,mapRouter).withDispatcher("priorityMailBox-dispatcher");
        wcMapReduceActor = system.actorOf(props, "WCMapReduceActor");
    }
    


}
