package com.coldface.code.concurrent;

public class MyRunnable implements Runnable {
	
	public static void main(String[] args){
        Thread thead=new Thread(new MyRunnable());
        thead.start();
    }
	

    public void run(){
         System.out.println("myRunnable:"+Thread.currentThread().getName());
     }

}
