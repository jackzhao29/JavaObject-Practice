package com.coldface.code.springaopexample.service;

import com.coldface.code.springaopexample.model.Employee;

/**
 * 服务类，处理Employee对象
 * @author coldface
 *
 */
public class EmployeeService {
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
