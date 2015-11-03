package com.coldface.code.concurrent.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 信用卡的用户
 * @author coldface
 *
 */
public class User implements Runnable {

	private String name; //用户名
	private MyCount myCount; //所要操作的账户
	private int iocash; //操作金额，有正负之分
	private ReadWriteLock myLock; //执行操作所需的锁对象
	private boolean isSearch; //是否查询
	
	
	User(String name,MyCount myCount,int iocash,ReadWriteLock myLock, boolean isSearch){
		this.name=name;
		this.myCount=myCount;
		this.iocash=iocash;
		this.myLock=myLock;
		this.isSearch=isSearch;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		if(isSearch){
			 //获取读锁
			 myLock.readLock().lock();
			 System.out.println("读：" + name + "正在查询" + myCount + "账户，当前金额为" + myCount.getCash());
             //释放读锁
			 myLock.readLock().unlock();
		}else{
			//获取写锁
			myLock.writeLock().lock();
			 //执行现金业务 
            System.out.println("写：" + name + "正在操作" + myCount + "账户，金额为" + iocash + "，当前金额为" + myCount.getCash()); 
            myCount.setCash(myCount.getCash() + iocash); 
            System.out.println("写：" + name + "操作" + myCount + "账户成功，金额为" + iocash + "，当前金额为" + myCount.getCash()); 
            //释放写锁
            myLock.writeLock().unlock();
		}

	}

}
