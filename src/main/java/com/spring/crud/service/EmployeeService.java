package com.spring.crud.service;

import java.util.List;

import com.spring.crud.model.Employee;

public interface EmployeeService {

	
	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
	void deleteEmployee(long id);
	
}
