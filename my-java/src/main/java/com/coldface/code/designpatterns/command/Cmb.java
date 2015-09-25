package com.coldface.code.designpatterns.command;
/**
 * 招商银行系统
 * @author coldface
 *
 */
public class Cmb {
	//存钱方法
	public void saveMoney(int money){
		System.out.println("向招商银行存入:"+money+"元");
	
	}
	//取钱方法
	public void getMoney(int money){
		System.out.println("从招商银行取出:"+money+"元");
	}

}
