package com.coldface.code.designpatterns.factory.abstractfactory;

import com.coldface.code.designpatterns.factory.PhoneService;
import com.coldface.code.designpatterns.factory.SimCard;

public interface ServiceOperatorFactory {
	//获取电话卡类型
	public SimCard getSimCard(String kind);
	//获取电话类型
	public PhoneService getPhone();

}
