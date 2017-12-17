package com.coldface.code.aop.service;

/**
 * 类HelloService.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年11月15日下午7:45:03
 */
public class HelloService {
  public void sayHello(int id, String name) {
    try {
      Thread.sleep(512);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Hello " + name + "(" + id + ")");
  }
}
