package com.coldface.code.concurrent;

public class MyThread3 extends Thread {
	
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("线程MyThread3第"+i+"次执行");
		}
	}

}
