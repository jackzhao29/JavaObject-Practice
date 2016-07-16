package com.coldface.code.akka.messagetype;

import java.io.Serializable;

/**
 * 类EventMessages.java的实现描述：消息接口
 * 
 * @author coldface
 * @date 2016年7月16日下午10:02:48
 */
public interface EventMessages {
  public static class EventMessage implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8903955773278281036L;

  }

  /**
   * 子系统注册的消息
   * 
   * @author zhaofei
   * @date 2016年7月16日下午9:59:47
   */
  public static final class Registration implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6233120373255178246L;

  }

}
