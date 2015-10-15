package com.coldface.code.springaopexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {
	
	@Before("@annotation(com.coldface.code.springaopexample.aspect.Loggable)")
	public void myAdvice(){
		System.out.println("Executing myAdvice!!");
	}

}
