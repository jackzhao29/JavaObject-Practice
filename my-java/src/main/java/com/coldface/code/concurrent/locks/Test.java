package com.coldface.code.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent.locks里面有三个重要的接口:Condition、Lock、ReadWriteLock
 * Condition:
 * Lock:
 * ReadWriteLock:
 * 普通锁
 * @author coldface
 *
 */
public class Test {

	public static void main(String[] args){
		//创建并发访问的账户
		MyCount myCount=new MyCount("955",1000);
		//创建一个锁对象
		Lock myLock=new ReentrantLock();
		//创建一个线程池
		ExecutorService pool=Executors.newCachedThreadPool();
		
		//创建一些并发访问用户
		User user1=new User("李三",myCount,-400,myLock);
		User user2=new User("李三1",myCount,100,myLock);
		User user3=new User("李三2",myCount,500,myLock);
		User user4=new User("李三3",myCount,-500,myLock);
		
		pool.execute(user1);
		pool.execute(user2);
		pool.execute(user3);
		pool.execute(user4);
		
		pool.shutdown();
	}
}
