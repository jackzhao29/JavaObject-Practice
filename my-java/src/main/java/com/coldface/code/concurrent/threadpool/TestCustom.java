package com.coldface.code.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * @author coldface
 *
 */
public class TestCustom {
	
	public static void main(String[] args){
		//创建等待队列
		BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(10);
	    //创建一个单线程执行程序，它可安排在给定延迟后运行命令或定期的执行
		/**
		 * public ThreadPoolExecutor(int corePoolSize,
	     *                     int maximumPoolSize,
	     *                     long keepAliveTime,
	     *                     TimeUnit unit,
	     *                     BlockingQueue<Runnable> workQueue)
		 * 参数：
	     * corePoolSize - 池中所保存的线程数，包括空闲线程。
	     * maximumPoolSize - 池中允许的最大线程数。
	     * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
	     * unit - keepAliveTime 参数的时间单位。
	     * workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
		 */
		ThreadPoolExecutor pool=new ThreadPoolExecutor(3,4,2,TimeUnit.MILLISECONDS,queue);
		
		//创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口 
	    Thread t1 = new MyThreadCustom("t1"); 
	    Thread t2 = new MyThreadCustom("t2"); 
	    Thread t3 = new MyThreadCustom("t3"); 
	    Thread t4 = new MyThreadCustom("t4"); 
	    Thread t5 = new MyThreadCustom("t5"); 
	    Thread t6 = new MyThreadCustom("t6"); 
	    Thread t7 = new MyThreadCustom("t7");
	    
	    //将线程放入池中进行执行 
	    pool.execute(t1); 
	    pool.execute(t2); 
	    pool.execute(t3); 
	    pool.execute(t4); 
	    pool.execute(t5); 
	    pool.execute(t6); 
	    pool.execute(t7); 
	    //关闭线程池 
	    pool.shutdown(); 
	}

	
}
