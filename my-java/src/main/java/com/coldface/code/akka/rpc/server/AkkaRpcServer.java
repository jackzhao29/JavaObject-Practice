package com.coldface.code.akka.rpc.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Props;
import akka.cluster.Cluster;


/**
 * 类AkkaRpcServer.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年8月10日下午8:22:31
 */
public class AkkaRpcServer {

  private Map<Class<?>, Object> server;
  private String port;
  private String hostName;
  private String akkaSystemName;
  private List<String> seedNodes;
  private ActorSystem system;

  public AkkaRpcServer() {
    this.server = new HashMap<Class<?>, Object>();
    this.hostName = "127.0.0.1";
    this.port = "9911";
    this.akkaSystemName = "AkkaRpcSystem";
    this.seedNodes = new ArrayList<String>();
    this.seedNodes.add("127.0.0.1:9911");
    this.seedNodes.add("127.0.0.1:8811");
  }

  public void start() {
    final Config config =
        ConfigFactory.parseString("akka.actor.provider=akka.cluster.ClusterActorRefProvider")
            .withFallback(
                ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + this.hostName))
        .withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port))
        .withFallback(ConfigFactory.parseString("akka.cluster.roles = [RpcServerActor]"));

    system = ActorSystem.create(akkaSystemName, config);

    for (int i = 0; i < seedNodes.size(); i++) {
      String hostPort = seedNodes.get(i);
      String[] hosts = hostPort.split(":");
      Address address =
          new Address("akka.tcp", akkaSystemName, hosts[0], Integer.valueOf(hosts[1]));
      Cluster.get(system).join(address);
    }

    system.actorOf(Props.create(RpcServerActor.class, server), "RpcServerActor");
  }

  public void close() {
    system.shutdown();
  }

  public Map<Class<?>, Object> getServer() {
    return server;
  }

  public void setServer(Map<Class<?>, Object> server) {
    this.server = server;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public String getAkkaSystemName() {
    return akkaSystemName;
  }

  public void setAkkaSystemName(String akkaSystemName) {
    this.akkaSystemName = akkaSystemName;
  }

  public List<String> getSeedNodes() {
    return seedNodes;
  }

  public void setSeedNodes(List<String> seedNodes) {
    this.seedNodes = seedNodes;
  }

  public ActorSystem getSystem() {
    return system;
  }

  public void setSystem(ActorSystem system) {
    this.system = system;
  }


}
