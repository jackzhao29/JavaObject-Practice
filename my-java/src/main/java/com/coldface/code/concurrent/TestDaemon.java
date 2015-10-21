package com.coldface.code.concurrent;

/**
 * 线程调度-守护线程
 * @author coldface
 * setDaemon(true)将线程标记为守护线程或用户线程，当正在运行的线程都是守护线程时，Java虚拟机退出
 *
 */
public class TestDaemon {
	
	public static void main(String[] args){
		MyCommon t1=new MyCommon();
		MyDaemon t2=new MyDaemon();
		
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
