package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
