package com.coldface.code.concurrent;

public class DoSomething implements Runnable {
	
	private String name;
	
	private int value;
	
	private static String names;
	
	public DoSomething(String name){
		this.name=name;
	}

	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			for(long k=1;k<100000000;k++);
				System.out.println(name+"   "+i);
		
		}

	}
	
	public static void main(String[] args){
		DoSomething ds1=new DoSomething("coldface");
		DoSomething ds2=new DoSomething("JavaThread");
		
		Thread t1=new Thread(ds1);
		Thread t2=new Thread(ds2);
		
		t1.start();
		t2.start();
		
	}
	
	//对方法同步
	public synchronized void getValue(){
		value++;
	}
	
	//对代码块同步
	public void getValue01(){
		synchronized(this){
			value++;
		}
	}
	
	//对静态方法同步
	public static synchronized void setValue(String name){
		DoSomething.names=name;
	}
	
	//对静态方法代码块同步
	public static void setValue01(String name){
		synchronized(DoSomething.class){
			DoSomething.names=name;
		}
	}
	
	

}
