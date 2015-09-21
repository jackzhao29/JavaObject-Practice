package com.coldface.code.designpatterns.factory.simplefactory;

import com.coldface.code.designpatterns.factory.SimCard;
import com.coldface.code.designpatterns.factory.SimCardPlanA;
import com.coldface.code.designpatterns.factory.SimCardPlanB;


/**
 * 生产打电话卡的工厂(也就是营业厅)
 * @author coldface
 *
 */
public class ChinaUnicomFactory {
	
	/**
	 * 生产电话卡的方法
	 * @param kind
	 * @return
	 */
	public static SimCard getSimCard(String kind){
		if("planA".equals(kind)){
			return new SimCardPlanA();
		}else if("planB".equals(kind)){
			return new SimCardPlanB();
		}else{
			System.out.println("没有找到你喜欢的套餐");
			return null;
		}
	}

}
