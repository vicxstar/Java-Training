package com.vic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: Step 10. Another ENTITY class For Receipts
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
//to specify which table in the database to use:
//@Table(name = "ShopReceipts")
public class CustomerReceipt {

	//declare the variables:
	private Customer customer;
	private Product product;
	private int itemsBought;
	private double totalSpent;
}
