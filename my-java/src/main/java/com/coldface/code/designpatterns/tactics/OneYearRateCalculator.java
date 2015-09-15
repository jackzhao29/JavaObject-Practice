package com.coldface.code.designpatterns.tactics;

/**
 * 计算一年定期存款利率的实现类
 * @author coldface
 *
 */
public class OneYearRateCalculator implements IRateCalculator {

	private double rate = 0.325;
	
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount * rate;
	}

}
