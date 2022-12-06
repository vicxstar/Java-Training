package com.vic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.entity.Customer;
import com.vic.entity.CustomerReceipt;
import com.vic.entity.Product;
import com.vic.persistence.CustomerDao;
import com.vic.persistence.ProductDao;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
//'@Service' indicates that this class has the business logic:
@Service
public class CustomerServiceImpl implements CustomerService {

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import 'CustomerDao', 'ProductDao' and '@Autowired':
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Collection<Product> findAllProducts() {
		//return all in the database:
		return productDao.findAll();
	}

	@Override
	public boolean loginCheck(Customer customer) {
		try {
		//instantiate a new 'Customer' object and search by their account ID:
		Customer cust = customerDao.findByNameAndPassword(customer.getName(), customer.getPassword());
		
		//check if the user has inputed the required details:
		if(customer !=  null)
			//return the customer:
			return true;
			
		return false;
		}
		catch(Exception exception) {
			
			return false;
		}
	}

	@Override
	public CustomerReceipt customerProductReceipt(int custId, int productId, int quantity) {
		//instantiate a new 'Customer' object and search by their account ID:
		Customer customer = customerDao.findById(custId).orElse(null);
		
		//instantiate a new 'Product' object and search by its account ID:
		Product product = productDao.findById(productId).orElse(null);
		
		//check to see if both the 'Customer' and 'Product' objects exist, and if there is enough stock for the purchase:
		if (product !=null && customer !=null && quantity < (product.getStockAmount())) {
			//declare a new double variable to convert data type of quantity for finding total cost:
			double doubleQ = (double) quantity;
			
			//declare a new double variable to find the total cost of the quantity of products wanted:
			double cost = doubleQ * (product.getPricePerUnit());
			
			//declare a new integer variable to set new products value for customer buying products:
			int prods = customer.getProducts();
			
			//add the amount of products the customer wants and add it with the amount of stock available:
			prods = prods + quantity;
			
			//use DAO JPQL methods to update balance + products of customer and stock of product:
			int updateCB = customerDao.updateBalanceAndProducts(cost, prods, custId);
			int updatePS = productDao.updateProductStock(quantity, productId);
			
			//check if the customer can afford the product and if the update methods returned a positive value (meaning they worked):
			if (cost < (customer.getBalance()) && updateCB !=0 && updatePS !=0) {
				
				return new CustomerReceipt(customer, product, quantity, cost);
			}
			//if the customer cannot afford the product:
			else {
				//return null:
				return null;
			}
		}
		//if both the 'Customer' and 'Product' objects do not exist, or if there is not enough stock for the purchase:
		else {
			//return null:
			return null;
		}
	}
}
