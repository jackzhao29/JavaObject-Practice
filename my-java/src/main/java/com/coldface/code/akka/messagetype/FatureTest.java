package com.coldface.code.akka.messagetype;


import java.util.Random;
import java.util.concurrent.Callable;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import akka.dispatch.OnComplete;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import scala.concurrent.Future;

/**
 * 类FatureTest.java的实现描述：Future类的测试示例
 * 
 * @author coldface
 * @date 2016年7月6日下午2:00:29
 */
public class FatureTest {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("hellofature");

        Callable<String> callable = new Callable<String>() {
            public String call() throws InterruptedException {
                Thread.sleep(10);
                if (new Random(System.currentTimeMillis()).nextBoolean()) {
                    return "Hello" + "World!";
                } else {
                    throw new IllegalArgumentException("参数错误");
                }
            }
        };
        // 通过Futures的静态方法future创建一个Future类，入参就是一个异步的计算
        Future<String> f = Futures.future(callable, system.dispatcher());

        f.onSuccess(new PrintResult<String>(), system.dispatcher());
        f.onFailure(new FailureResult(), system.dispatcher());
        System.out.println("这个地方是外面");
        f.andThen(new OnComplete<String>(){
            @Override
            public void onComplete(Throwable failure,String success) {
                System.out.println("这里是andThen");
            }
        }, system.dispatcher()).andThen(new OnComplete<String>(){
            @Override
            public void onComplete(Throwable failure,String success){
                System.out.println("这里是andThen2");
            }
        }, system.dispatcher());
    }

    public final static class PrintResult<T> extends OnSuccess<T> {
        @Override
        public final void onSuccess(T t) {
            System.out.println(t);
        }
    }

    public final static class FailureResult extends OnFailure {
        @Override
        public void onFailure(Throwable failure) {
            System.out.println("进入错误的处理");
            failure.printStackTrace();
        }
    }


}
