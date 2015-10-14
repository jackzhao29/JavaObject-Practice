package com.coldface.code.designpatterns.templatemethod;
/**
 * 模版方法模式（Template Method Pattern）——定义一个操作中算法的框架，而将一些步骤延迟到子类中。 
 * 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。 
 * @author coldface
 *
 */
public class Test {
	
	public static void main(String[] args){
		ChinaMobile chinaMobile=new ChinaMobile();
		chinaMobile.service();
		
	    ChinaUnicom chinaUnicom=new ChinaUnicom();
	    chinaUnicom.setNewCustomer(false);
	    chinaUnicom.service();
	}

}
