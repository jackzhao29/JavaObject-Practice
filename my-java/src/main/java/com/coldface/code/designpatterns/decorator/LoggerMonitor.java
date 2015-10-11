package com.coldface.code.designpatterns.decorator;

/**
 * 监控日志实现类
 * @author coldface
 *
 */
public class LoggerMonitor implements IMonitor {

	//系统发生异常时记录日志
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("异常发生记录日志");

	}

}
