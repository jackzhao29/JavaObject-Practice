package com.coldface.code.designpatterns.templatemethod;

/**
 * 移动实现类
 * @author coldface
 *
 */
public class ChinaMobile extends ServiceOperator {

	    //办卡方法
	    @Override
		public  void requestCard(){
			System.out.println("办一张移动电话卡");
		}
		//选号方法
	    @Override
		public void selectNumber(){
			System.out.println("选一个牛逼的移动号");
		}
	    
	    //钩子方法(移动不管是新用户还是老用户都需要重新选号)
	    @Override
		public boolean isNewCustomer(){
			return true;
		}
}
