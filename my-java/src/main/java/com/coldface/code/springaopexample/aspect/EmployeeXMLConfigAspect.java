package com.coldface.code.springaopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 使用Spring的配置文件定义切面
 * @author coldface
 *
 */
public class EmployeeXMLConfigAspect {

	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("EmployeeXMLConfigAspect:: Before invoking getName() method");
		Object value=null;
		try{
			value=proceedingJoinPoint.proceed();
		}catch(Throwable e){
			e.printStackTrace();
		}
		System.out.println("EmployeeXMLConfigAspect:: After invoking getName() method. Return value="+value);
		return value;
	}
}
