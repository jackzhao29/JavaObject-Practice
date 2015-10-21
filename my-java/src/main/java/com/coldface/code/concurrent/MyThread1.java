package com.coldface.code.concurrent;

public class MyThread1 extends Thread {
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("线程MyThread1第"+i+"次执行!");
			try {
				//线程休眠2秒
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
