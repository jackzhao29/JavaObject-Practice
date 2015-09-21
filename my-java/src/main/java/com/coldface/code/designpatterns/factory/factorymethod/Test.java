package com.coldface.code.designpatterns.factory.factorymethod;

import com.coldface.code.designpatterns.factory.SimCard;

/**
 * 工厂方法模式（Factory Method Pattern）——定义了一个创建对象的接口，
 * 但由子类决定要实例化的类是哪一个，工厂方法让类把实例化推迟到子类
 * 
 * 继续简单工厂的例子，能生产电话卡的不光是联通啊，移动、电信也行啊，只要是运营商都卖手机卡啊。于是，我们将上面的工厂改造一下，提供一个运营商工厂的接口 （ServiceOperatorFactory），
 * 联通工厂（ChinaUnicomFactory）、移动工厂 （ChinaMobileFactory）都实现了运营商接口的实现类，
 * 再增加两种卡的类型，移动的全球通卡（SimCardQQT）和神州行卡 （SimCardSZX）。这样，当用户想办联通卡时就用联通的工厂，想用移动卡时就用移动的工厂，
 * 没准哪天都不想用了，想换个电信的，没问题，不用修改 写好的代码，再加一个电信的工厂就行了，扩展性得到提高了吧。
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		ServiceOperatorFactory factory=null;
		
		//获取移动的全球通电话卡
		factory=new ChinaMobileFactory();
		SimCard simCardQQT=factory.getSimCard("qqt");
		simCardQQT.servie();
		
		//获取联通的套餐B计划电话卡
		factory=new ChinaUnicomFactory();
		SimCard simCardPlanB=factory.getSimCard("planB");
		simCardPlanB.servie();
		
	}

}
