package com.coldface.code.concurrent.locks;

import java.util.concurrent.locks.Lock;

/**
 * 信用卡的用户
 * @author coldface
 *
 */
public class User implements Runnable {

	private String name; //用户名
	private MyCount myCount; //所要操作的账户
	private int iocash; //操作金额，有正负之分
	private Lock myLock; //执行操作所需的锁对象
	
	
	User(String name,MyCount myCount,int iocash,Lock myLock){
		this.name=name;
		this.myCount=myCount;
		this.iocash=iocash;
		this.myLock=myLock;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		//获取锁
		myLock.lock();
		//执行现金业务
		System.out.println(name+"正在操作"+myCount+"账户，金额为"+iocash+"，当前金额为"+myCount.getCash());
		myCount.setCash(myCount.getCash()+iocash);
		System.out.println(name+"操作"+myCount+"账户成功，金额为"+iocash+"，当前金额为"+myCount.getCash());
		//释放锁，否则别的线程无法获取锁
		myLock.unlock();
		

	}

}
