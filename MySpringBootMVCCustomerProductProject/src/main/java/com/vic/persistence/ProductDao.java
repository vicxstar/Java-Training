package com.vic.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vic.entity.Product;

/**
 *
 * @author vic
 * date: 04/12/2022
 * purpose: The DAO INTERFACE (PERSISTENCE LAYER) FOR PRODUCTS
 *
 */
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	//TO UPDATE PRODUCT STOCK:
	//use JPQL to retrieve an object from database:
	//use '@Modifying' to modify a query and change the way it needs to be executed:
	@Modifying
	//use '@Transactional' to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query("update Product set stock = stock - :quantity where productId = :id")
	int updateProductStock(@Param("quantity") int quantity, @Param("id") int id);

}
