package com.vic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 24/11/2022
 * purpose: Step 1. The ENTITY class
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
public class Book {

	//declare the variables:
	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfCopies;
}
