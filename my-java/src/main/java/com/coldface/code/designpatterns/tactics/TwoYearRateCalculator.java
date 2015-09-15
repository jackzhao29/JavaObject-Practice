package com.coldface.code.designpatterns.tactics;

/**
 * 计算两年定期存款利率
 * @author coldface
 *
 */
public class TwoYearRateCalculator implements IRateCalculator {

	private double rate = 0.375;
	
	public double calculate(double amount) {
		// TODO Auto-generated method stub
		return amount * rate;
	}

}
