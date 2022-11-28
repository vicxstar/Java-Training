package com.vic.service;

import java.util.Collection;

import com.vic.entity.DvdLibrary;

/**
 *
 * @author vic
 * date: 25/11/2022
 * purpose: Step 4. The DTO INTERFACE (SERVICE LAYER)
 *
 */
public interface DvdLibraryService {

	//create the methods to make a call to the DAO to retrieve data from the database:
	//import 'Collection' and 'DvdLibrary':
	Collection<DvdLibrary>getAllDvds();
	DvdLibrary searchDvds(int dvdId);
	boolean addDvd(DvdLibrary dvd);
	boolean deleteDvd(int dvdId);
	boolean editDvd(int dvdId);
	boolean updateDvd(DvdLibrary dvd);
//	Collection<DvdLibrary> searchDvdByTitle(String title);
}
