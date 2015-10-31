package com.coldface.code.concurrent.threadpool;

public class MyThread extends Thread {
	
	private String name;
	public MyThread(String name){
		this.name=name;
	}
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"----"+name+"正在执行.....");
	}

}
