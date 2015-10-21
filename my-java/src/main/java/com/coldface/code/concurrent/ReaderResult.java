package com.coldface.code.concurrent;

/**
 * 线程的交互
 * 
 * 获取计算结果并输出
 * @author coldface
 *
 * 多个线程在等待一个对象锁时使用notifyAll()方法
 */
public class ReaderResult extends Thread {

	Calculator c;
	
	public ReaderResult(Calculator c){
		this.c=c;
	}
	
	public void run(){
		synchronized(c){
			
			try {
				System.out.println(Thread.currentThread()+"等待计算结果.....");
				c.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread()+"计算结果为:"+c.total);
		}
	}
	
	
	
	public static void main(String[] args){
		Calculator calculator=new Calculator();
		
		//启动三个线程，分别获取计算结果
		new ReaderResult(calculator).start();
		new ReaderResult(calculator).start();
		new ReaderResult(calculator).start();
		
		//启动计算线程
		calculator.start();
		
	}
}
