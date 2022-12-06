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
 * date: 28/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	//FIND CUTOMER BY ID:
	public Customer findUserByCustNameAndPassword(String custName, String password);
	
	//TO UPDATE BANK BALANCE:
	//use JPQL to retrieve an object from database:
	//use '@Modifying' to modify a query and change the way it needs to be executed:
	@Modifying
	//use '@Transactional' to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query("update Customer set bankBalance = :fBal where accountId = :accountId")
	int updateBalance(@Param("accountId") int accountId, @Param("fBal") double finalBal);
}
