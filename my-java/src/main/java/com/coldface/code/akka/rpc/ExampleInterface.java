package com.coldface.code.akka.rpc;

import java.io.Serializable;

/**
 * 类ExampleInterface.java的实现描述：接口
 * @author coldface
 * @date 2016年8月10日下午7:50:22
 */
public interface ExampleInterface extends Serializable {
  public String sayHello(String name);

}
