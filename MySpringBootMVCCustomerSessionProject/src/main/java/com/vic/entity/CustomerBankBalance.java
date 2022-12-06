/**
 * 
 */
package com.vic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 10. Another ENTITY class
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
public class CustomerBankBalance {

	//declare the variables:
	private Customer customer;
	private double allowanceA;
	private double allowanceB;
	private double deduction;
	private double totalBalance;
}
