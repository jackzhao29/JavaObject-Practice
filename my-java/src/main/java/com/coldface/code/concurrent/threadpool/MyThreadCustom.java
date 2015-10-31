package com.coldface.code.concurrent.threadpool;

public class MyThreadCustom extends Thread {
	
	private String name;
	
	MyThreadCustom(String name){
		this.name=name;
	}

	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"---"+name+"正在执行....");
		try {
			//休息1000毫秒
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
