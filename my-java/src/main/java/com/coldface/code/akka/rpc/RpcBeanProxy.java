package com.coldface.code.akka.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

/**
 * 类RpcBeanProxy.java的实现描述：客户端的动态代理类
 * 
 * @author coldface
 * @date 2016年8月10日下午8:04:39
 */
public class RpcBeanProxy implements InvocationHandler {

  private ActorRef rpcClientServer;

  private Class<?> clz;

  @SuppressWarnings("unchecked")
  public <T> T proxy(ActorRef rpcClientServer, Class<T> clz) {
    this.rpcClientServer = rpcClientServer;
    this.clz = clz;
    Class<?>[] clzz = new Class<?>[] {clz};
    return (T) Proxy.newProxyInstance(clz.getClassLoader(), clzz, this);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method,
   * java.lang.Object[])
   */
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // TODO Auto-generated method stub
    Object result = null;
    RpcEvent.CallMethod callMethod = new RpcEvent.CallMethod(method.getName(), args, clz.getName());
    Future<Object> future = Patterns.ask(rpcClientServer, callMethod,
        new Timeout(FiniteDuration.create(10, TimeUnit.SECONDS)));
    Object obj = Await.result(future, FiniteDuration.create(10, TimeUnit.SECONDS));
    result = obj;
    return result;
  }

}
