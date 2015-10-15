package com.coldface.code.springaopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * After Advice例子
 * @author coldface
 *
 */
@Aspect
public class EmployeeAfterAspect {
	
	@After("args(name)")
	public void logStringArguments(String name){
		System.out.println("Running after Advice. String argument passed="+name);
	}
	
	//在切点表达式中使用within来申明该通知会在一个类的所有方法上执行 
	@AfterThrowing("within(com.coldface.code.springaopexample.model.Employee)")
	public void logExecptions(JoinPoint joinPoint){
		System.out.println("Exception thrown in Employee Method="+joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* getName())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("getNameReturningAdvice executed. Returned String="+returnString);
	}

}
