package com.vic.service;

import java.util.Collection;
import com.vic.entity.Customer;
import com.vic.entity.CustomerBankBalance;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface CustomerService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection', 'Employee' and 'EmployeePayslip':
	Collection<Customer> findAllCustomers();
	Customer searchCustomersById(int accountId);
	boolean deleteCustomer(int accountId);
	boolean incrementBankBalance(int accountId, double increment);
	Customer transferMoney(int accountId, int recipientId, double amount);
	CustomerBankBalance generateBankBalace(int accountId);
	public boolean loginCheck(Customer customer);
}
