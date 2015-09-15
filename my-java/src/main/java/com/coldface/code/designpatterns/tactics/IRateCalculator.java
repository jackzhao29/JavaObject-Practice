package com.coldface.code.designpatterns.tactics;

/**
 * 策略模式：针对一种计算，定义一系列的算法，由用户决定具体使用哪一个算法完成计算
 * 例如：
 * 比如，提供一个计算银行存款利率的接口，对于不同的存款方式（活期、一年定期、两年定期），提供不同的算法实现类，
 * 由用户决定使用哪种存款方式来计算利率。如果银行计算利率的算法发生了变化（如又增加了三年定期、五年定期的算法），
 * 对于用户的使用不产生任何影响，因为用户使用的是统一的计算接口，也符合了针对接口编程，不针对实现编程的设计原则。
 * @author coldface
 *
 */
public interface IRateCalculator {
	//计算存款利率
	public double calculate(double amount);
}
