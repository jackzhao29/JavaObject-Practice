package com.coldface.code.concurrent;

public class User {
	private String code;
	private int cash;
	
	User(String code,int cash){
		this.code=code;
		this.cash=cash;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	/**
	 * 业务方法(同步方法)
	 * @param 添加x元
	 * 注意：在使用synchronized关键字的时候，尽可能避免在synchronized方法或者块中使用sleep或者yield方法，因为synchronized程序块占着对象睡觉，严重影响效率。
	 */
	public synchronized void oper(int x){
		try {
			Thread.sleep(10L);
			this.cash +=x;
			System.out.println(Thread.currentThread().getName()+"运行结束，增加"+x+"元，当前账号余额为："+cash);
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return "User{code="+code+",cash="+cash+"}";
	}
	
	public void opern(int x){
		try {
			Thread.sleep(10L);
			synchronized(this){
				this.cash +=x;
				System.out.println(Thread.currentThread().getName()+"运行结束，增加"+x+"元，当前账号余额为："+cash);
			}
	        Thread.sleep(10L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
