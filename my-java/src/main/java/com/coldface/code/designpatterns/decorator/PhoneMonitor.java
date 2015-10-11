package com.coldface.code.designpatterns.decorator;

/**
 * 电话通知实现类
 * @author coldface
 *
 */
public class PhoneMonitor implements IMonitor {

	private IMonitor monitor;
	
	public PhoneMonitor(IMonitor monitor){
		this.monitor=monitor;
	}
	//系统异常时电话通知
	public void handle() {
		// TODO Auto-generated method stub
		monitor.handle();
		System.out.println("电话已通知");

	}

}
