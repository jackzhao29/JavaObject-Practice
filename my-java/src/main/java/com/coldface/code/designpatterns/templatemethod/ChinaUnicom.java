package com.coldface.code.designpatterns.templatemethod;

/**
 * 联通实现类
 * @author coldface
 *
 */
public class ChinaUnicom extends ServiceOperator {

	//联通不管是新用户还是老用户由用户自己去决定
	private boolean isNewCustomer;
	
	
	@Override
	public void requestCard() {
		// TODO Auto-generated method stub
		System.out.println("办一张联通电话卡");

	}

	@Override
	public void selectNumber() {
		// TODO Auto-generated method stub
		System.out.println("选一个方便记忆的联通号码");

	}

	public boolean isNewCustomer() {
		return isNewCustomer;
	}

	public void setNewCustomer(boolean isNewCustomer) {
		this.isNewCustomer = isNewCustomer;
	}
	
	

}
