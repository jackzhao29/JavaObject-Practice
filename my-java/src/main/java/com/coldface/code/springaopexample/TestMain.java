package com.coldface.code.springaopexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coldface.code.springaopexample.service.EmployeeService;

/**
 * 运行入口
 * @author coldface
 *
 */
public class TestMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
			EmployeeService employeeService=ctx.getBean("employeeService",EmployeeService.class);
			System.out.println(employeeService.getEmployee().getName());
			employeeService.getEmployee().setName("Jack zhao");
			employeeService.getEmployee().throwException();

	}

}
