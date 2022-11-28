package com.vic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 25/11/2022
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
public class Student {

	//to get the 'ID' method:
	//specifies the primary key of an entity
	@Id
	private int studentId;
	private String studentName;
	private String studentAddress;
	private String studentEmail;
	private double studentFoodBalance;
}
