package com.coldface.code.akka.rpc.server;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.coldface.code.akka.rpc.RpcEvent;
import com.coldface.code.akka.rpc.RpcEvent.CallMethod;

import akka.actor.UntypedActor;

/**
 * 类RpcServer.java的实现描述：rpc服务端actor
 * 
 * @author coldface
 * @date 2016年8月10日下午7:53:05
 */
public class RpcServerActor extends UntypedActor {

  private Map<String, Object> proxyBeans;

  public RpcServerActor(Map<Class<?>, Object> beans) {
    proxyBeans = new HashMap<String, Object>();
    for (Iterator<Class<?>> it = beans.keySet().iterator(); it.hasNext();) {
      Class<?> inface = it.next();
      proxyBeans.put(inface.getName(), beans.get(inface));
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
   */
  @Override
  public void onReceive(Object message) throws Exception {
    // TODO Auto-generated method stub
    if (message instanceof RpcEvent.CallMethod) {
      //想Server发送方法调用请求
      CallMethod event = (CallMethod) message;
      Object bean = proxyBeans.get(event.getBeanName());
      Object[] params = event.getParams();
      List<Class<?>> paraTypes = new ArrayList<Class<?>>();
      Class<?>[] paramerTypes = new Class<?>[] {};
      if (params != null) {
        for (Object param : params) {
          paraTypes.add(param.getClass());
        }
      }

      Method method =
          bean.getClass().getMethod(event.getMethodName(), paraTypes.toArray(paramerTypes));
      Object obj = method.invoke(bean, params);
      getSender().tell(obj, getSelf());
    }
  }

}
