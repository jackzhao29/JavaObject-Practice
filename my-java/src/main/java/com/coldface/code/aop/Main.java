package com.coldface.code.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coldface.code.aop.service.HelloService;

/**
 * 类Main.java的实现描述：TODO 类实现描述
 * @author coldface
 * @date 2016年11月15日下午7:45:54
 */
public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
      BeanFactory factory =new ClassPathXmlApplicationContext("spring-aop.xml");
      HelloService helloService = (HelloService)factory.getBean("helloService");
      helloService.sayHello(1,"测试");
  }
}
