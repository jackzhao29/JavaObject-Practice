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
   * @author coldface
   * @date 2016年7月16日下午9:59:47
   */
  public static final class Registration implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6233120373255178246L;

  }
  /**
   * 
   * 类RawNginxRecord.java的实现描述：内存中的Nginx日志
   * 
   * @author coldface
   * @date 2016年7月16日下午9:45:24
   */
  public static class RawNginxRecord implements EventMessages {

    private String sourceHost;
    private String line;

    public RawNginxRecord(String sourceHost, String line) {
      this.sourceHost = sourceHost;
      this.line = line;
    }

    public String getSourceHost() {
      return sourceHost;
    }

    public void setSourceHost(String sourceHost) {
      this.sourceHost = sourceHost;
    }

    public String getLine() {
      return line;
    }

    public void setLine(String line) {
      this.line = line;
    }
  }

  /**
   * 类NginxRecord.java的实现描述：解析出了事件内功的Nginx记录
   * 
   * @author coldface
   * @date 2016年7月16日下午9:52:21
   */
  public static class NginxRecord implements EventMessages {

    private String sourceHost;
    private String line;
    private String eventCode;

    public NginxRecord(String sourceHost, String line, String eventCode) {
      this.sourceHost = sourceHost;
      this.line = line;
      this.eventCode = eventCode;
    }

    public String getSourceHost() {
      return sourceHost;
    }

    public String getLine() {
      return line;
    }

    public String getEventCode() {
      return eventCode;
    }


  }

  /**
   * 类FilteredRecord.java的实现描述：TODO通过了拦截器的日志记录
   * 
   * @author coldface
   * @date 2016年7月16日下午9:55:02
   */
  public class FilteredRecord implements EventMessages {

    private String sourceHost;

    private String line;

    private String eventCode;

    private String logDate;

    private String realIp;

    public FilteredRecord(String sourceHost, String line, String eventCode, String logDate,
        String realIp) {
      this.sourceHost = sourceHost;
      this.line = line;
      this.eventCode = eventCode;
      this.logDate = logDate;
      this.realIp = realIp;
    }

    public String getSourceHost() {
      return sourceHost;
    }

    public String getLine() {
      return line;
    }

    public String getEventCode() {
      return eventCode;
    }

    public String getLogDate() {
      return logDate;
    }

    public String getRealIp() {
      return realIp;
    }
  }
}
