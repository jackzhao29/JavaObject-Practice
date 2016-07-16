package com.coldface.code.akka.messagetype;

/**
 * 类NginxRecord.java的实现描述：解析出了事件内功的Nginx记录
 * 
 * @author coldface
 * @date 2016年7月16日下午9:52:21
 */
public class NginxRecord implements EventMessages {

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
