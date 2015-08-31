package com.coldface.code.concurrent;

public class ThreadExample {
	
	public static void main(String[] args){
        /**
         * 创建了两个线程，他们的构造器引用同一个Counter实例。Counter.add方法是同步在实例上
         * 因为add方法是实例方法并且被标记上synchronized关键字，因此每次只允许一个线程调用该方法
         * 另外一个线程必须要等到第一个线程退出add()方法时，才能继续执行方法
         */
        Counter counter=new Counter();
        Thread threadA=new CounterThread(counter);
        Thread threadB=new CounterThread(counter);

        threadA.setName("ThreadA");
        threadA.start();
        threadB.setName("ThreadB");
        threadB.start();
        System.out.println("count:"+counter.count);


        /**
         * ThreadC和ThreadD不在引用同一个Counter实例，CounterA和CounterB的
         * add()方法同步在他们所属的对象上，调用counterA的add方法将不会阻塞调用counterB的add方法
         */
        Counter counterA=new Counter();
        Counter counterB=new Counter();
        Thread threadC=new CounterThread(counterA);
        Thread threadD=new CounterThread(counterB);

        threadC.setName("ThreadC");
        threadD.setName("ThreadD");
        threadC.start();
        threadD.start();
    }

}
