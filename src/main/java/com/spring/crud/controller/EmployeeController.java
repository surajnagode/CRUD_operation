package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.Employee;
import com.spring.crud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee),HttpStatus.CREATED);
		
	}
	
	@GetMapping()
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully..",HttpStatus.OK);
		
	}
}
