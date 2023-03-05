package com.spring.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.exception.ResourceNotFoundException;
import com.spring.crud.model.Employee;
import com.spring.crud.repository.EmployeeRepository;
import com.spring.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
				Optional<Employee> employee = employeeRepository.findById(id);
			if(employee.isPresent()) {
				return employee.get();
			}else {
				throw new ResourceNotFoundException("Employee", "Id", id);
			}
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
           Employee existEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
           existEmployee.setFirstName(employee.getFirstName());
           existEmployee.setLastName(employee.getLastName());
           existEmployee.setEmail(employee.getEmail());
           existEmployee.setAge(employee.getAge());
           
           employeeRepository.save(existEmployee);
		return existEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
