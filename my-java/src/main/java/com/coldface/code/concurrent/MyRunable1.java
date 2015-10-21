package com.coldface.code.concurrent;

public class MyRunable1 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			System.out.println("线程MyRunable1第"+i+"次执行!");
		
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
