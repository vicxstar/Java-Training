package com.vic.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
*
* @author vic
* date: 28/11/2022
* purpose: Step 1. The ENTITY class
*
*/

//use '@' to import the libraries from Lombok:
//to add the getters and setters:
@Data
//to add the default parameter:
@NoArgsConstructor
//to add the parameters constructor:
@AllArgsConstructor
//to get the 'ToString' method:
@ToString
//to get the 'Entity' method:
//specifies that the class is an entity
@Entity
//to specify which table in the database to use:
//@Table(name = "Employees")
public class Employee {

	//declare the variables:
	//to get the 'ID' method:
	//specifies the primary key of an entity
	@Id
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "employeeId")
	private int empId;
	
	//to name the column:
	@Column(name = "firstName")
	private String empFirstName;
	
	//to name the column:
	@Column(name = "lastName")
	private String empLastName;
		
	//to name the column:
	@Column(name = "email")
	private String empEmail;
	
	//to name the column:
	@Column(name = "phoneNumber")
	private String empPhoneNum;
	
	//to name the column:
	@Column(name = "hireDate")
	private LocalDate hireDate;
		
	//to name the column:
	@Column(name = "jobId")
	private String jobId;
		
	//to name the column:
	@Column(name = "salary")
	private double empSalary;
		
	//to name the column:
	@Column(name = "commision_pct")
	private double empCommission;
		
	//to name the column:
	@Column(name = "managerId")
	private int managerId;
		
	//to name the column:
	@Column(name = "departmentId")		
	private int departmentId;
		
	//to name the column:
	@Column(name = "departmentName")
	private String departmentName;
	
	//to name the column:
	@Column(name = "role")
	private String role;
}
