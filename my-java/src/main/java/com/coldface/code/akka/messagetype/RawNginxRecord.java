package com.coldface.code.akka.messagetype;

/**
 * 
 * 类RawNginxRecord.java的实现描述：内存中的Nginx日志
 * 
 * @author coldface
 * @date 2016年7月16日下午9:45:24
 */
public class RawNginxRecord implements EventMessages {

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
