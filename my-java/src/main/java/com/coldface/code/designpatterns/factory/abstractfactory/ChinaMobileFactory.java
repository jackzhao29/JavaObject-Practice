package com.coldface.code.designpatterns.factory.abstractfactory;

import com.coldface.code.designpatterns.factory.IPhoneMobile;
import com.coldface.code.designpatterns.factory.PhoneService;
import com.coldface.code.designpatterns.factory.SimCard;
import com.coldface.code.designpatterns.factory.SimCardDGDD;
import com.coldface.code.designpatterns.factory.SimCardQQT;

/**
 * 移动工厂类
 * @author coldface
 *
 */
public class ChinaMobileFactory implements ServiceOperatorFactory {

	public  SimCard getSimCard(String kind) {
		// TODO Auto-generated method stub
		if("dgdd".equals(kind)){
			return new SimCardDGDD();
		}else if("qqt".equals(kind)){
			return new SimCardQQT();
		}else {
			return null;
		}
	}
	
	public PhoneService getPhone(){
		return new IPhoneMobile();
	}

}
