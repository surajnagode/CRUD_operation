package com.spring.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "First Name")
	private String firstName;
	
	@Column(name = "Last Name")
	private String lastName;
	
	@Column(name ="Email")
	private String email;
	
	@Column(name ="Age")
	private int age;

}
