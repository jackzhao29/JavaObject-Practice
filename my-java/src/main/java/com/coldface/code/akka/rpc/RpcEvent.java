package com.coldface.code.akka.rpc;

import java.io.Serializable;

/**
 * 类RpcEvent.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年8月10日下午8:02:54
 */
public interface RpcEvent {
  public static class CallMethod implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -270985140381332645L;

    private String methodName;

    private Object[] params;

    public CallMethod(String methodName, Object[] params) {
      super();
      this.methodName = methodName;
      this.params = params;
    }

    private String beanName;

    public CallMethod(String methodName, Object[] params, String beanName) {
      super();
      this.methodName = methodName;
      this.params = params;
      this.beanName = beanName;
    }

    public String getMethodName() {
      return methodName;
    }

    public void setMethodName(String methodName) {
      this.methodName = methodName;
    }

    public Object[] getParams() {
      return params;
    }

    public void setParams(Object[] params) {
      this.params = params;
    }

    public String getBeanName() {
      return beanName;
    }

    public void setBeanName(String beanName) {
      this.beanName = beanName;
    }
  }

}
