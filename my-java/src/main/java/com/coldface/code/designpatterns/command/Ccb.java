package com.coldface.code.designpatterns.command;
/**
 * 建行系统
 * @author coldface
 *
 */
public class Ccb {
	//存钱方法
	public void cunqian(int money){
		System.out.println("向建行存入:"+money+"元");
	}
	//取钱方法
	public void quqian(int money){
		System.out.println("向建设取出:"+money+"元");
	}

}
