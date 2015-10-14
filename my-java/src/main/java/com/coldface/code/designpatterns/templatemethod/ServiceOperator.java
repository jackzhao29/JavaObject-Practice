package com.coldface.code.designpatterns.templatemethod;

/**
 * 运营商抽象类
 * 模版方法模式还可以进一步进行扩展。对于某些基本方法的调用与否，可能需要一些条件，这时，我们可以在模版抽象类中定义一个控制这些条件的方法，称之为钩子方法（Hood Method），
 * 由子类去设定这个条件，以使不同的实现类能够做出不同的处理。
 * @author coldface
 *
 */
public abstract class ServiceOperator {
	//办卡方法(基本方法)
	public abstract void requestCard();
	//选号方法(基本方法)
	public abstract void selectNumber();
	
	//模板方法
	final public void service(){
		//先办卡
		this.requestCard();
		if(isNewCustomer()){
			//后选号
			this.selectNumber();
		}
	}
	
	//钩子方法
	public boolean isNewCustomer(){
		return true;
	}

}
