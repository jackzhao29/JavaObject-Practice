package com.coldface.code.concurrent;

/**
 * 线程调度-让步
 * @author coldface
 *
 */
public class Test2 {

	public static void main(String[] args){
		MyThread2 t1=new MyThread2();
		Thread t2=new Thread(new MyRunnable2());
		
		t2.start();
		t1.start();
		
	}
}
