package com.coldface.code.designpatterns.tactics;

/**
 * 策略模式——定义算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 * 针对一种计算，定义一系列的算法，由用户决定具体使用哪一个算法完成计算.
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		
		//本金100
		double amount = 100;
		double rate;
		IRateCalculator rateCalculator;
		//计算活期存款利率
		rateCalculator = new CurrentRateCalculator();
		rate = rateCalculator.calculate(amount);
		System.out.println("活期存款利率为：" + rate);
		//计算一年定期存款利率
		rateCalculator = new OneYearRateCalculator();
		rate = rateCalculator.calculate(amount);
		System.out.println("一年定期存款利率为：" + rate);
		//计算两年定期存款利率
		rateCalculator = new TwoYearRateCalculator();
		rate = rateCalculator.calculate(amount);
		System.out.println("两年定期存款利率为：" + rate);
	}

}
