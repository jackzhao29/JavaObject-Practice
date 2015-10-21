package com.coldface.code.concurrent;

/**
 * 线程的调度-休眠
 * @author coldface
 * 哪个线程调用sleep，就休眠哪个线程
 *
 */
public class TestMyThraed1AndMyRunable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread1 t1=new MyThread1();
		Thread t2=new Thread(new MyRunable1());
		
		t1.start();
		t2.start();

	}

}
