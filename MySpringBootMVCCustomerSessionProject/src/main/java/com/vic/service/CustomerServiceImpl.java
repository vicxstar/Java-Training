package com.vic.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vic.entity.Customer;
import com.vic.entity.CustomerBankBalance;
import com.vic.persistence.CustomerDao;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
//'@Service' indicates that this class has the business logic:
@Service
public class CustomerServiceImpl implements CustomerService {

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import 'CustomerDao' and '@Autowired':
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Collection<Customer> findAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer searchCustomersById(int accountId) {
		return customerDao.findById(accountId).orElse(null);
	}

	@Override
	public boolean deleteCustomer(int accountId) {
		if (searchCustomersById(accountId) != null) {
			customerDao.deleteById(accountId);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementBankBalance(int accountId, double increment) {
		//method from the Dao:
		return customerDao.updateBalance(accountId, increment) > 0;
	}


	@Override
	public CustomerBankBalance generateBankBalace(int accountId) {
		Customer customer = searchCustomersById(accountId);
		
		if(customer != null) {
			double allowanceA = .18*customer.getBankBalance();
			double allowanceB = .12*customer.getBankBalance();
			double deduction = .08*customer.getBankBalance();
			double totalBalance = customer.getBankBalance() + allowanceA + allowanceB - deduction;
			
			CustomerBankBalance custBankBal =new CustomerBankBalance(customer, allowanceA, allowanceB, deduction, totalBalance);
			return custBankBal;
		}
		return null;
	}

	@Override
	public Customer transferMoney(int accountId, int recipientId, double amount) {
		//instantiate a new 'Customer' object and search by their account ID:
		Customer customer = customerDao.findById(accountId).get();
		
		//check if the customer has enough money:
		if(customer.getBankBalance() < amount)
			//if they don't return null:
			return null; 
		//if they do:
		else {
			//instantiate a new 'Customer' object for the recipient and search by their account ID:
			Customer recipient = customerDao.findById(recipientId).orElse(null);
			//if the account ID exists:
			if(recipient != null) {
				//add the amount inputed by the 'customer' into the 'recipient''s bank balance:
				recipient.setBankBalance(recipient.getBankBalance()+amount);
				//decrease the 'customer''s bank balance by the amount they inputed:
				customer.setBankBalance(customer.getBankBalance()-amount);
				//save the changes made:
				customerDao.save(recipient);
				customerDao.save(customer);
				
				//return the 'Customer' object:
				return customer;
		}
		//if the account ID does not exist:
		else
			//return null:
			return null;
		}
	}

	@Override
	public boolean loginCheck(Customer customer) {
		try {
			
			Customer cust = customerDao.findUserByCustNameAndPassword(customer.getCustName(), customer.getPassword());
			
			if(cust != null)
				return true;
			
			return false;
		}
		 catch(Exception exception) {
			
				return false;
			}
	}
}
