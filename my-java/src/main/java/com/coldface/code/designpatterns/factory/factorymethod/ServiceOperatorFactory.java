package com.coldface.code.designpatterns.factory.factorymethod;

import com.coldface.code.designpatterns.factory.SimCard;

/**
 * 运营商接口
 * @author coldface
 *
 */
public interface ServiceOperatorFactory {
	//生产电话卡方法
	public SimCard getSimCard(String kind);

}
