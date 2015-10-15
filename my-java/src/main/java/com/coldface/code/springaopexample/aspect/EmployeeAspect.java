package com.coldface.code.springaopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Before Aspect例子
 * @author coldface
 *
 */
@Aspect
public class EmployeeAspect {
	//@Before注解用于创建Before advice，注解中的字符串参数是Pointcut表达式
	
	@Before("execution(public String getName())")
	public void getNameAdvice(){
		//getNameAdvice()通知将会在任何带有public String getName()方法签名的Spring Bean方法执行时执行。
		System.out.println("Executing Advice on getName()");
	}
	
	@Before("execution(* com.coldface.code.springaopexample.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
	

}
