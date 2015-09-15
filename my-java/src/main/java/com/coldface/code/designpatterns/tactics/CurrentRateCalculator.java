package com.coldface.code.designpatterns.tactics;

/**
 * 计算活期存款利率实现类
 * @author coldface
 *
 */
public class CurrentRateCalculator implements IRateCalculator{
	private double rate=0.35;
	
	public double calculate(double amount){
		return amount * rate;
	}

}
