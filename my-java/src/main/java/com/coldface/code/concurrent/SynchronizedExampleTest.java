package com.coldface.code.concurrent;

/**
 * 线程的同步-同步方法
 * @author coldface
 * 线程同步时保证多线程安全访问竞争资源的一种手段。
 * 对于同步需要完成下列2个操作
 * 1.把竞争资源访问的标示为private
 * 2.使用synchronized关键字同步方法或代码
 * 
 * synchronized关键字使用说明
 * synchronized只能标记非抽象的方法，不能标示成员变量
 *
 */
public class SynchronizedExampleTest {
	 public static void main(String[] args) { 
         User u = new User("张三", 100); 
         MyThreadSynchronized t1 = new MyThreadSynchronized("线程A", u, 20); 
         MyThreadSynchronized t2 = new MyThreadSynchronized("线程B", u, -60); 
         MyThreadSynchronized t3 = new MyThreadSynchronized("线程C", u, -80); 
         MyThreadSynchronized t4 = new MyThreadSynchronized("线程D", u, -30); 
         MyThreadSynchronized t5 = new MyThreadSynchronized("线程E", u, 32); 
         MyThreadSynchronized t6 = new MyThreadSynchronized("线程F", u, 21); 

         t1.start(); 
         t2.start(); 
         t3.start(); 
         t4.start(); 
         t5.start(); 
         t6.start(); 
 } 
}
