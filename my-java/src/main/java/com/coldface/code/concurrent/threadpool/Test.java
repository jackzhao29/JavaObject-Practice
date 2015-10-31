package com.coldface.code.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author coldface
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个可固定线程数的线程池
		//ExecutorService pool=Executors.newFixedThreadPool(2);
		
		//创建一个使用单个work线程的Executor
		//ExecutorService signPool=Executors.newSingleThreadExecutor();
		
		//创建可变大小的线程池
		//ExecutorService cachePool=Executors.newCachedThreadPool();
		
		//定时任务线程池
		//ScheduledExecutorService scheduledPool=Executors.newScheduledThreadPool(3);
		
		//单线程定时任务线程池
		ScheduledExecutorService scheduledSinglePool=Executors.newSingleThreadScheduledExecutor();
		
		//创建实现了Thread或者Runnable接口对象
		Thread t1=new MyThread("t1");
		Thread t2=new MyThread("t2");
		Thread t3=new MyThread("t3");
		Thread t4=new MyThread("t4");
		Thread t5=new MyThread("t5");
		
		//将线程放入线程池中进行执行
		/**
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		**/
		
		//将线程放入单个work线程中
		/**
		signPool.execute(t1);
		signPool.execute(t2);
		signPool.execute(t3);
		signPool.execute(t4);
		signPool.execute(t5);
		**/
		
		//将线程放入可变大小的线程池中
		/**
		cachePool.execute(t5);
		cachePool.execute(t2);
		cachePool.execute(t3);
		cachePool.execute(t4);
		cachePool.execute(t1);
		**/
		
		//将线程放入定时任务线程池中
		/**
		scheduledPool.execute(t1);
		scheduledPool.execute(t2);
		scheduledPool.execute(t5);
		//延迟执行
		scheduledPool.schedule(t4, 2000, TimeUnit.MICROSECONDS);
		scheduledPool.schedule(t3, 1000, TimeUnit.MICROSECONDS);
		**/
		
		//将线程放入单线程定时任务线程池中
		scheduledSinglePool.execute(t1);
		scheduledSinglePool.execute(t2);
		scheduledSinglePool.execute(t5);
		//延迟执行
		scheduledSinglePool.schedule(t4, 2000, TimeUnit.MICROSECONDS);
		
		
		//关闭线程池
		//pool.shutdown();
		//signPool.shutdown();
		//cachePool.shutdown();
		//scheduledPool.shutdown();
		scheduledSinglePool.shutdown();
	}

}
