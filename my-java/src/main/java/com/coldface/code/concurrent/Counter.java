package com.coldface.code.concurrent;

public class Counter {
	
	long count=0;

    public synchronized void add(long value){
        System.out.print("Thread Name:"+Thread.currentThread().getName());
        this.count += value;
        System.out.println("     count:"+this.count);
    }

}
