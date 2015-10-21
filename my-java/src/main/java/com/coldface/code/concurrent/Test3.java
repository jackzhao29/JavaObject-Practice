package com.coldface.code.concurrent;

/**
 * 线程调度-合并
 * @author coldface
 *
 *线程的合并的含义就是将几个并行执行的线程合并为一个单线程执行，应用场景是当一个线程必须等待另一个线程执行完毕才能执行时可以使用join方法
 */
public class Test3 {

	public static void main(String[] args){
		MyThread3 thread=new MyThread3();
		thread.start();
		
		for(int i=1;i<=20;i++){
			System.out.println("主线程第"+i+"次执行");
			//当主线程执行到第6次时，让thread线程执行，直到thread线程执行完毕，主线程继续执行
			if(i>5){
				try {
					//thread线程合并到主线程中，主线程停止执行过程，转而执行thread线程，直到thread线程执行完毕后继续
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
