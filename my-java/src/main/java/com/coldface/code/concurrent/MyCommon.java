package com.coldface.code.concurrent;

public class MyCommon extends Thread {
	
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("线程MyCommon第"+i+"次执行");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
