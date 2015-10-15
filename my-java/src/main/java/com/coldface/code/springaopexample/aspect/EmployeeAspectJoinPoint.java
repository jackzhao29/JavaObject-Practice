package com.coldface.code.springaopexample.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 连接点和通知参数
 * @author coldface
 *
 */
@Aspect
public class EmployeeAspectJoinPoint {
	
	//使用JoinPoint作为通知方法的参数并且使用他获取方法签名或者目标对象
	//在连接点中使用args()表达式来匹配任何方法的任何参数，如果我们使用它，则我们需要在通知方法中使用同参数相同的名称，我们也可以在通知参数中使用泛型
	@Before("execution(public void com.clodface.code.springaopexample.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before runing loggingAdvice on method="+joinPoint.toString());
		System.out.println("Agruments Passed="+Arrays.toString(joinPoint.getArgs()));
	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	@Before("args(name)")
	public void logStringArguments(String name){
		System.out.println("String argument passed="+name);
	}

}
