package com.coldface.code.akka.rpc.client;

import java.util.Arrays;
import java.util.Collections;

import com.coldface.code.akka.rpc.RpcBeanProxy;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.routing.AdaptiveLoadBalancingGroup;
import akka.cluster.routing.ClusterRouterGroup;
import akka.cluster.routing.ClusterRouterGroupSettings;
import akka.cluster.routing.HeapMetricsSelector;


/**
 * 类AkkaRpcClient.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年8月10日下午8:33:51
 */
public class AkkaRpcClient extends Thread {
  private ActorSystem system;

  private ActorRef rpc;

  private ActorRef clientServer;

  private static AkkaRpcClient instance = null;

  public AkkaRpcClient() {
    this.start();
    final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2552)
        .withFallback(ConfigFactory.parseString("akka.cluster.roles = [RpcClientActor]"))
        .withFallback(ConfigFactory.load());
    system = ActorSystem.create("EsbSystem", config);

    int totalInstances = 100;
    Iterable<String> routeesPaths = Arrays.asList("/user/RpcServerActor");
    boolean allowLocalRoutees = false;
    ClusterRouterGroup clusterRouterGroup = new ClusterRouterGroup(
        new AdaptiveLoadBalancingGroup(HeapMetricsSelector.getInstance(),
            Collections.<String>emptyList()),
        new ClusterRouterGroupSettings(totalInstances, routeesPaths, allowLocalRoutees,
            "RpcServerActor"));
    rpc = system.actorOf(clusterRouterGroup.props(), "rpcCall");
    clientServer = system.actorOf(Props.create(RpcClientActor.class, rpc), "client");

    Cluster.get(system).registerOnMemberUp(new Runnable() {
      // 加入集群成功后的回调事件，恢复当先线程的中断
      public void run() {
        synchronized (instance) {
          System.out.println("notify");
          instance.notify();
        }
      }
    });
  }

  public static AkkaRpcClient getInstance() {
    if (instance == null) {
      instance = new AkkaRpcClient();
      synchronized (instance) {
        try {
          // 中断当前线程，等待加入集群成功后恢复
          System.out.println("wait");
          instance.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    return instance;
  }

  public <T> T getBean(Class<T> clz) {
    return new RpcBeanProxy().proxy(clientServer, clz);
  }
}
