package com.coldface.code.concurrent;

public class MyThread2 extends Thread {
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("线程MyThread2第"+i+"次执行");
		}
	}

}
