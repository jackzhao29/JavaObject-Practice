package com.coldface.code.designpatterns.factory.simplefactory;

import com.coldface.code.designpatterns.factory.SimCard;


/**
 * 简单工厂模式又称静态工厂方法模式，就是通过一个工厂类来负责对象的创建
 * 
 * 比如，你要办一张联通的电话卡，联通有A计划套餐、B计划套餐，不管什么套餐，都能打电话，你只要到营业厅买一张卡就行了。
 * 其中，电话卡是一个接口 （SimCard），它有一个方法就是用来打电话（service），
 * A计划和B计划的卡都是其实现类（SimCardPlanA、 SimCardPlanB），
 * 营业厅就是一个工厂，用来生产电话卡（ChinaUnicomFactory），你只要告诉它你要什么套餐就行了。
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		//获取联通A套餐的电话卡
		SimCard planASimCard=ChinaUnicomFactory.getSimCard("planA");
		planASimCard.servie();
		
		//获取联通B套餐的电话卡
		SimCard planBSimCard=ChinaUnicomFactory.getSimCard("planB");
		planBSimCard.servie();
	}

}
