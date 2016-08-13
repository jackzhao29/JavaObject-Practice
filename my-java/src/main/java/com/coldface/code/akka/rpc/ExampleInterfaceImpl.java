package com.coldface.code.akka.rpc;

/**
 * 类ExampleInterfaceImpl.java的实现描述：接口实现类
 * @author coldface
 * @date 2016年8月10日下午7:51:16
 */
public class ExampleInterfaceImpl implements ExampleInterface {
  /**
   * 
   */
  private static final long serialVersionUID = -4148579444174238795L;

  /* (non-Javadoc)
   * @see com.coldface.code.akka.rpc.ExampleInterface#sayHello(java.lang.String)
   */
  public String sayHello(String name) {
    // TODO Auto-generated method stub
    System.out.println("welcome come "+name);
    return "Hello "+ name;
  }

}
