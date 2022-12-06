package com.vic.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vic.entity.Customer;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER) FOR CUSTOMERS
 *
 */
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	//FIND CUTOMER BY ID:
	public Customer findByNameAndPassword(String name, String password);
	
	//TO UPDATE CUSTOMER BALANCE:
	//use JPQL to retrieve an object from database:
	//use '@Modifying' to modify a query and change the way it needs to be executed:
	@Modifying
	//use '@Transactional' to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query("update Customer set balance = balance - :cost, products = products + :quantity where custId = :custId")
	int updateBalanceAndProducts(@Param("cost") double cost, @Param("quantity") int quantity, @Param("custId") int id);


}
