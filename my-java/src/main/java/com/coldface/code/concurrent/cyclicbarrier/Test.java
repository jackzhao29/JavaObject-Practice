package com.coldface.code.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 障碍器
 * 使用场景是：一个大型的任务，需要分配好多子任务去执行，只有当所有子任务都执行完成时候，才能执行主任务
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		//创建障碍器，并设置MainTask为所有数量的线程都达到障碍点时候所有执行的任务
		CyclicBarrier cb=new CyclicBarrier(7, new MainTask());
		new SubTask("A",cb).start();
		new SubTask("B",cb).start();
		new SubTask("C",cb).start();
		new SubTask("D",cb).start();
		new SubTask("E",cb).start();
		new SubTask("F",cb).start();
		new SubTask("G",cb).start();
	}

}
