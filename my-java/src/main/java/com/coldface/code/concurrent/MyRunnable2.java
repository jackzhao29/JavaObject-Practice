package com.coldface.code.concurrent;

public class MyRunnable2 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			System.out.println("线程MyRunnable2第"+i+"次执行");
			//当前线程让出cpu
			Thread.yield();
		}

	}

}
