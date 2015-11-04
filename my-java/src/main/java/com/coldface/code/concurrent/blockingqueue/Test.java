package com.coldface.code.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 * BlockingQueue成员介绍:
 * 1.ArrayBlockingQueue:基于数组的阻塞队列
 * 2.LinkedBlockingQueue:基于链表的阻塞队列.
 * ArrayBlockingQueue与LinkedBlockingQueue区别:
 * 1.ArrayBlockingQueue在生产者放入数据和消费者获取数据，都共用同一个锁对象.
 * 2.ArrayBlockingQueue在插入和删除元素时不会产生或销毁任何额外的对象实例，而LinkedBlockingQueue则生成一个额外的Node对象，对GC的性能有影响
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		BlockingQueue queue=new ArrayBlockingQueue(20);
		for(int i=0;i<30;i++){
			try {
				if(queue.size()<20){
					queue.put(i);
					System.out.println("向队列中已添加"+i+"元素");
				}else{
					System.out.println("从队列中获取元素:"+queue.poll());
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("程序运行完毕，即将退出.....");
		System.out.println(queue.peek());
		System.out.println(queue.element());
		try {
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
