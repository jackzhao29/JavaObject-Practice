package com.coldface.code.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SubTask extends Thread {
	
	private String name;
	private CyclicBarrier cb;
	
	SubTask(String name,CyclicBarrier cb){
		this.name=name;
		this.cb=cb;
	}
	
	public void run(){
		System.out.println("【子任务"+name+"】开始执行了");
		//模拟正在执行的任务
		for(int i=0;i<999999;i++);
		System.out.println("【子任务"+name+"】已经执行完毕，并且障碍器已经完成");
		try {
			//通知障碍器已经完成
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
