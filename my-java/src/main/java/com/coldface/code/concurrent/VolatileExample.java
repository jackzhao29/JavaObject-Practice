package com.coldface.code.concurrent;

import java.util.concurrent.TimeUnit;

public class VolatileExample {
	
	/**
	 * volatile特性：1.可见性；2.禁止指令重排序
	 * 如果stop不用volatile修饰，while(!stop)被重排序，导致3s后程序不会停止运行
	 */
	private volatile static  boolean stop;

	
	public static void main(String[] args) throws InterruptedException{
		Thread workThread=new Thread(new Runnable(){
			public void run(){
				int i=0;
				while(!stop){
					i++;
					try {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("=====1"+i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		workThread.start();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("====3");
		stop=true;
	}
	
	
	

}
