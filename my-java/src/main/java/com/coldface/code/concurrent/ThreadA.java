package com.coldface.code.concurrent;

/**
 * 线程的交互
 * 
 * 计算出其他线程锁计算的数据
 * @author coldface
 * 
 * 一个线程在等待一个对象锁时候使用notify()方法
 * 
 * 关键点：
 * 1.必须从同步环境内调用wait()、notify()、notifyAll()方法，线程不能调用对象上等待或通知的方法，除非它拥有哪个对象的锁
 * 2.wait()、notify()、notifyAll()都是Object的实例方法，与每个对象具有锁一样，每个对象可以有一个线程列表，他们等待来自该信号(通知),线程通过直线对象上的
 * wait()方法获得这个等待列表。从那时起它不再执行任何其他指令，直到调用对象的notify()方法位置。
 *
 */
public class ThreadA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadB b=new ThreadB();
		//启动计算线程
		b.start();
		
		//线程A拥有b对象上的锁，线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
		synchronized(b){
			try {
				System.out.println("等待计算b完成计算......");
				//当前线程A等待
				b.wait();
				System.out.println("======");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("b对象计算的总和是:"+b.total);
		}

	}

}
