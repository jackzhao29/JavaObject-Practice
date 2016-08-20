package com.coldface.code.akka.rpc.client;

import com.coldface.code.akka.rpc.ExampleInterface;

/**
 * 类ClientMain.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2016年8月10日下午8:39:56
 */
public class ClientMain {
  public static void main(String[] args) {
    //初始化akkaRpcClient对象
    AkkaRpcClient client = AkkaRpcClient.getInstance();
    long start = System.currentTimeMillis();
    
    //通话akkaRpcClient中的getBean方法获取Server端的接口实现类的实例对象。
    ExampleInterface example = client.getBean(ExampleInterface.class);
    System.out.println(example.sayHello("akka-rpc-测试"));
    
    long time = System.currentTimeMillis() - start;
    System.out.println("time :" + time);
}
}
