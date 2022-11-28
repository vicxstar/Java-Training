package com.vic.entity;

import java.time.LocalDate; //better than using 'sql.date' or 'util.date'

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 25/11/2022
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
//to get the 'Entity' method:
//specifies that the class is an entity
@Entity
//to name the table:
//@Table(name = "Dvd Library")
public class DvdLibrary {

	//declare the variables:
	//to get the 'ID' method:
	//specifies the primary key of an entity
	@Id
	//to name the column:
	//don't add any spaces in the column titles
	@Column(name = "DvdID")
	private int dvdId;
	
	//to name the column:
	@Column(name = "Title")
	private String title;
	
	//to name the column:
	@Column(name = "ReleaseDate")
	private LocalDate releaseDate;
	
	//to name the column:
	@Column(name = "MPAARating")
	private String mpaaRating;
    
	//to name the column:
	@Column(name = "DirectorsName")
	private String directorsName;
    
	//to name the column:
	@Column(name = "ProductionStudio")
	private String studio;
		
	//to name the column:
	@Column(name = "UserReview")	
    private String userReview;
}
