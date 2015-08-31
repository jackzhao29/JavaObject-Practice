package com.coldface.code.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleThreadPool {
	
	private BlockingQueue taskQueue=null;
    private List<PoolThread> threads=new ArrayList<PoolThread>();
    private boolean isStopped=false;

    public SimpleThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue=new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads;i++){
            threads.add(new PoolThread(taskQueue));
        }

        for(PoolThread thread:threads){
            thread.start();
        }
    }

    public synchronized void execute(Runnable runnable){
        if(this.isStopped)throw
          new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(runnable);
    }

    public synchronized void stop(){
        this.isStopped=true;
        for(PoolThread thread:threads){
            thread.stop();
        }
    }


}
