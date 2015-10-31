package com.coldface.code.concurrent;

public class MyThreadSynchronized extends Thread {
	
	private User user;
	private int y=0;
	
	MyThreadSynchronized(String name,User u,int y){
		super(name);
		this.user=u;
		this.y=y;
	}
	
	public void run(){
		//user.oper(y);
		user.opern(y);
	}

}
