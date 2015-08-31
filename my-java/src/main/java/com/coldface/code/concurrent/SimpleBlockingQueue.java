package com.coldface.code.concurrent;

import java.util.LinkedList;
import java.util.List;

public class SimpleBlockingQueue {
	
	private List list=new LinkedList();
    private int limit=10;

    public SimpleBlockingQueue(int limit){
        this.limit=limit;
    }

    //向队列中添加元素
    public synchronized void put(Object item) throws InterruptedException{
        //当队列满时，需要进入等待状态
        if(list.size()==limit){
            wait();
        }

        //当队列空时，唤醒所有线程
        if(list.size()==0){
            notifyAll();
        }

        //向队列中添加元素
        this.list.add(item);
    }

    //从队列中获取元素
    public synchronized Object take() throws InterruptedException{
        //当队列空时，需要进入等待状态
        if(this.list.size()==0){
            wait();
        }

        //当队列满时，唤醒所有线程
        if(this.list.size() == this.limit){
            notifyAll();
        }

        //获取队列中的元素，并且移除队列
        return this.list.remove(0);
    }

}
