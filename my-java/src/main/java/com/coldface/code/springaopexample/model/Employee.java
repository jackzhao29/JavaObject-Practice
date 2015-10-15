package com.coldface.code.springaopexample.model;

import com.coldface.code.springaopexample.aspect.Loggable;

/**
 * 模型类
 * @author coldface
 *
 */
public class Employee {
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	//使用自定义注解
	@Loggable
	public void setName(String name){
		this.name=name;
	}
	
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}

}
