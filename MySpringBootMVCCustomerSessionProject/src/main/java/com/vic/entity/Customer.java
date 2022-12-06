package com.vic.entity;

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
* purpose: Step 1. The ENTITY class For Customer
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
@Table(name = "Customer")
public class Customer {

	//declare the variables:
	//to get the 'ID' method:
	//specifies the primary key of an entity
	@Id
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "accountId")
	private int accountId;
	
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "custName")
	private String custName;
	
	//to name the column:
	@Column(name = "password")
	private String password;
	
	//to name the column:
	@Column(name = "custAddress")
	private String custAddress;
	
	//to name the column:
	@Column(name = "custNumber")
	private int custNumber;
		
	//to name the column:
	@Column(name = "bankBalance")
	private double bankBalance;
}
