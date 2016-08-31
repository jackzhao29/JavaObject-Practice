package com.coldface.code.akka.rpc.client;

/**
 * 类AkkaRpcClientFactory.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2016年8月10日下午8:39:29
 */
public class AkkaRpcClientFactory {
  private AkkaRpcClient instance = null;

  public AkkaRpcClient getClient() {
      if (instance == null) {
          instance = AkkaRpcClient.getInstance();
      }
      return instance;
  }

}
