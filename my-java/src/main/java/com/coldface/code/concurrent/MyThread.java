package com.coldface.code.concurrent;

public class MyThread extends Thread{
	public static void main(String[] args){
        System.out.println("main:"+Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            MyThread myThread=new MyThread();
            myThread.start();
        }
    }

    @Override
    public void run(){
        System.out.println("MyThread:"+Thread.currentThread().getName());
    }

    Thread thread=new Thread() {
        public void run() {
            System.out.println("thread:" + thread.currentThread().getName());
        }
    };

}
