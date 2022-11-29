package com.vic.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vic.entity.DvdLibrary;

/**
*
* @author vic
* date: 25/11/2022
* purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
*
*/
//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface DvdLibraryDao extends JpaRepository<DvdLibrary, Integer> {
	
	//to search via title (the Jpa does this for us):
	//import 'List'
	List<DvdLibrary> findByTitle(String title);
}
