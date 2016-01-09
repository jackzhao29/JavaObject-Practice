package com.coldface.code.concurrent; 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * 类TestCachedThreadPool.java的实现描述：TODO 类实现描述 
 * @author coldface 2016年1月4日 下午3:20:05 
 */
public class TestCachedThreadPool {
    
    public static void main(String[] args){
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(new MyTestRunable());
            System.out.println("************"+i+"************");
        }
        executorService.shutdown();
    }
}

class MyTestRunable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+"线程被调用了");
        while(true){
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"线程睡眠了");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block log.error("error message", e);  
            }
            
        }
    }
}


