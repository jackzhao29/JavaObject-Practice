package com.coldface.code.concurrent.ProduceConsumeModel;

/**
 * 仓库
 * @author coldface
 *
 */
public class Godown {

	public static final int max_size=100; //最大库存量
	public int curnum; //当前库存量
	
	public Godown(){}
	public Godown(int curnum){
		this.curnum=curnum;
	}
	
	/**
	 * 生产指定产品的数量
	 */
	public synchronized void produce(int needNum){
		//是否需要生产
		while(needNum + curnum > max_size){
			System.out.println("要生产的产品数量"+needNum+"超过剩余库存量"+(max_size - curnum)+",暂时不能执行生产任务");
			try {
				//当前的生产线程等待
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//满足生产条件，则进行生产。
		curnum +=needNum;
		System.out.println("已经生产了"+needNum+"个产品，现仓储量为"+curnum);
		//唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}
	
	/**
	 * 消费指定数量的产品
	 * @param neednum
	 */
	public synchronized void consume(int neednum){
		//是否有能消费的产品
		while(curnum<neednum){
			
			try {
				//当前的消费线程等待
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//满足消费条件，则进行消费
		curnum -=neednum;
		System.out.println("已经消费了"+neednum+"个产品，现仓储量为"+curnum);
		//唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}
}
