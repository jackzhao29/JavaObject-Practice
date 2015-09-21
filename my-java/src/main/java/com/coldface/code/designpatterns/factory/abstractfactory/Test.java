package com.coldface.code.designpatterns.factory.abstractfactory;

import com.coldface.code.designpatterns.factory.PhoneService;
import com.coldface.code.designpatterns.factory.SimCard;

/**
 * 
 * 抽象工厂模式（Abstract Factory Pattern）——提供一个接口， 
 * 用于创建相关或依赖对象的家族，而不需要明确指定具体类。
 * 还是继续工厂模式的例子，现在运营商可不光是卖卡了，还卖手机。你想买个IPhone5，还得分清是买联通版还是移动版。去联通营业厅，肯定不能买到移动版的 IPhone5啊。
 * 于是，我们改造一下上面的例子，增加一个电话的接口（Phone），有一个方法打电话（call），定义两个实现类，联通版 IPhone（IPhoneUnicom）和移动版IPhone（IPhoneMobile），
 * 在运营商接口中增加一个获取电话的方法 （getPhone，假设营业厅只卖IPhone）。当使用不同的运营商工厂时，得到的电话卡和电话都是指定运营商的，你不需要指定说我要个什么版本的电话，
 * 因为联通不卖移动版的电话。 
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		ServiceOperatorFactory factory=null;
		
		//获取使用动感地带卡的移动IPhone手机
		factory=new ChinaMobileFactory();
		PhoneService mobilePhone=factory.getPhone();
		mobilePhone.call();
		SimCard simCardDGDD=factory.getSimCard("dgdd");
		simCardDGDD.servie();
		
		//获取使用套餐A计划的联通IPhone手机
		factory=new ChinaUnicomFactory();
		PhoneService unicomPhone=factory.getPhone();
		unicomPhone.call();
		SimCard simCardPlanA=factory.getSimCard("planA");
		simCardPlanA.servie();
		
	}

}
