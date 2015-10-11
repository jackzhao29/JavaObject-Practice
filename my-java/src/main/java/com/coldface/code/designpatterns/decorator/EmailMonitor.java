package com.coldface.code.designpatterns.decorator;

/**
 * 发送邮件实现类
 * @author coldface
 *
 */
public class EmailMonitor implements IMonitor {

	private IMonitor monitor;
	
	public EmailMonitor(IMonitor monitor){
		this.monitor=monitor;
	}
	
	//系统发生异常时发送邮件
	public void handle() {
		// TODO Auto-generated method stub
		monitor.handle();
		System.out.println("邮件已发送");
	}

}
