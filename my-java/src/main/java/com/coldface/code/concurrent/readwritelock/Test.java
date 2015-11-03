package com.coldface.code.concurrent.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 读写锁
 * 在实际开发中，最好在能用读写锁的情况下使用读写锁，而不要使用普通锁，以求性能更好
 * @author coldface
 *
 */
public class Test {

	public static void main(String[] args){
		//创建并发访问的账户
		MyCount myCount=new MyCount("955",1000);
		//创建一个锁对象
		ReadWriteLock myLock=new ReentrantReadWriteLock(false);
		//创建一个线程池
		ExecutorService pool=Executors.newFixedThreadPool(2);		
		//创建一些并发访问用户
		User user1=new User("李三",myCount,-400,myLock,false);
		User user2=new User("李三1",myCount,100,myLock,false);
		User user3=new User("李三2",myCount,500,myLock,false);
		User user5=new User("李三5",myCount,0,myLock,true);
		User user4=new User("李三3",myCount,-500,myLock,false);
		
		pool.execute(user1);
		pool.execute(user5);
		pool.execute(user2);
		pool.execute(user3);
		pool.execute(user4);
		
		pool.shutdown();
	}
}
