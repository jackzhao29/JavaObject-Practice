package com.coldface.code.concurrent.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 类CallableDemo.java的实现描述：Callable接口示例
 * 
 * @author coldface 2016年1月4日 下午4:01:04
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果保存到List中
            resultList.add(future);
        }

        //遍历任务的结果
        for (Future<String> fs : resultList) {
            //打印各个线程执行的结果
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {

                // TODO Auto-generated catch block log.error("error message", e);

            } catch (ExecutionException e) {

                // TODO Auto-generated catch block log.error("error message", e);

            } finally {
                executorService.shutdown();
            }
        }
        
        

    }

}

class TaskWithResult implements Callable<String> {
    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务转给ExecutorService的submit方法，则该方法自动在一个线程上执行.
     */
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "线程的call()方法被自动调用，干活!!!!!");
        //模拟一个耗时的操作
        for (int i = 9999999; i > 0; i--)
            ;
        return Thread.currentThread().getName() +"======"+ id + "call()方法执行完毕后返回的结果success!";
    }
}
