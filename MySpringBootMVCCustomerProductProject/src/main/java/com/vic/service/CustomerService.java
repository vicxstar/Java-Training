package com.vic.service;

import java.util.Collection;

import com.vic.entity.Customer;
import com.vic.entity.CustomerReceipt;
import com.vic.entity.Product;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface CustomerService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	
	//TO FIND ALL PRODUCTS
	//import 'Collection' and 'Product'
	Collection<Product> findAllProducts();
	
	//TO CHECK LOGIN DETAILS:
	//import 'Customer'
	public boolean loginCheck(Customer customer);

	//TO GENERATE RECEIPT:
	//import 'CustomerReceipt'
	CustomerReceipt customerProductReceipt(int custId, int productId, int quantity);
}
