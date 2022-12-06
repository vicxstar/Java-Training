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
 * date: 04/12/2022
 * purpose: Another ENTITY class For Products
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
@Table(name = "ShopProducts")
public class Product {

	//declare the variables:
	
	//to get the 'ID' method:
	//specifies the primary key of an entity
	@Id
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "productId")
	private int productId;
	
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "productName")
	private String productName;
		
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "pricePerUnit")
	private double pricePerUnit;
	
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "stockAmount")
	private int stockAmount;
}
