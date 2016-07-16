package com.coldface.code.akka.messagetype;

/**
 * 
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
