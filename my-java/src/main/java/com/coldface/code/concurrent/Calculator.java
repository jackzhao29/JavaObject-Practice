package com.coldface.code.concurrent;

/**
 * 计算线程
 * @author coldface
 *
 */
public class Calculator extends Thread {

	int total;
	public void run(){
		synchronized(this){
			for(int i=0;i<101;i++){
				total +=i;
			}
			//（计算完成后）通知所有在此对象上等待的线程
			//notifyAll();
			notify();
		}
		
	}
}
