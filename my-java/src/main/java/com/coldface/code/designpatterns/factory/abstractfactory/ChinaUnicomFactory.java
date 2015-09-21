package com.coldface.code.designpatterns.factory.abstractfactory;

import com.coldface.code.designpatterns.factory.IPhoneUnicom;
import com.coldface.code.designpatterns.factory.PhoneService;
import com.coldface.code.designpatterns.factory.SimCard;
import com.coldface.code.designpatterns.factory.SimCardPlanA;
import com.coldface.code.designpatterns.factory.SimCardPlanB;

/**
 * 联通工厂
 * @author coldface
 *
 */
public class ChinaUnicomFactory implements ServiceOperatorFactory {

	public SimCard getSimCard(String kind) {
		// TODO Auto-generated method stub
		if("planA".equals(kind)){
			return new SimCardPlanA();
		}else if("planB".equals(kind)){
			return new SimCardPlanB();
		}else {
			System.out.println("没有找到你喜欢的套餐类型");
			return null;
		}
	}
	
	public PhoneService getPhone(){
		return new IPhoneUnicom();
	}

}
