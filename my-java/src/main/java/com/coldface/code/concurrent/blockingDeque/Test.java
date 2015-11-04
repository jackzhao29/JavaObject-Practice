package com.coldface.code.concurrent.blockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞栈
 * @author coldface
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingDeque bDeque=new LinkedBlockingDeque(20);
		
		for(int i=0;i<30;i++){
			try {
				if(bDeque.size()<20){
				   bDeque.put(i);
				   System.out.println("向阻塞栈中添加元素:"+i);
				}else{
					System.out.println("从阻塞栈中获取元素:"+bDeque.poll());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("程序执行完毕，即将退出");
		System.out.println(bDeque.peek());
		System.out.println(bDeque.element());
		System.out.println(bDeque.getFirst());
		System.out.println(bDeque.getLast());
		System.out.println(bDeque.pop());
	}

}
