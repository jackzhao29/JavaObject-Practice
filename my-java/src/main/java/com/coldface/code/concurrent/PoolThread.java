package com.coldface.code.concurrent;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread{
	
	private BlockingQueue<Runnable> taskQueue=null;
    private boolean isStopped=false;

    public PoolThread(BlockingQueue<Runnable> queue){
        taskQueue=queue;
    }

    public void run(){
        while (!isStopped()){
            try{
                Runnable runnable=taskQueue.take();
                runnable.run();
            }catch (Exception ex){
                //写日志或者报告异常
                //但是保持线程运行
            }
        }
    }

    public synchronized void toStop(){
        isStopped=true;
        //打断池中线程的dequeue()调用
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }

}
