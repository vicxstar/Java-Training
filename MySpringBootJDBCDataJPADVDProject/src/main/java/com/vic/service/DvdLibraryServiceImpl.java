package com.vic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.entity.DvdLibrary;
import com.vic.persistence.DvdLibraryDao;

/**
 *
 * @author vic
 * date: 25/11/2022
 * purpose: Step 7. The SERVICE IMPLEMENTAION  (SERVICE LAYER - implementation)
 *
 */
//'@Service' indicates that this class has the business logic:
@Service
public class DvdLibraryServiceImpl implements DvdLibraryService {

	//Instantiate a new object of the 'persistence implementation' class - BookDaoImpl (which implements the persistence interface):
	//the '@Autowired' annotation is used to tell Spring which candidate it can use:
	//import 'BookDao' and '@Autowired':
	@Autowired
	private DvdLibraryDao dvdLibraryDao;
	
	@Override
	public Collection<DvdLibrary> getAllDvds() {
		return dvdLibraryDao.findAll();
	}

	@Override
	public DvdLibrary searchDvds(int dvdId) {
		return dvdLibraryDao.findById(dvdId).orElse(null);
	}

	@Override
	public boolean addDvd(DvdLibrary dvd) {
		if (searchDvds(dvd.getDvdId()) == null) {
			// save means : save and update
			dvdLibraryDao.save(dvd);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDvd(int dvdId) {
		if (searchDvds(dvdId) == null) {
			// save means : save and update
			dvdLibraryDao.deleteById(dvdId);
			return true;
		}
		return false;
	}

	@Override
	public boolean editDvd(int dvdId) {
		//check if the dvd object exists:
		if(searchDvds(dvdId) != null) {
			//add the new details:
			return true; 
		}
		//if it doesn't exist, do nothing:
		return false;
	}
	
	@Override
	public boolean updateDvd(DvdLibrary dvd) {
		dvdLibraryDao.save(dvd);
		return true;
	}
//	
//	@Override
//	public Collection<DvdLibrary> searchDvdByTitle(String title) {
//		return dvdLibraryDao.findByAll(title);
//	}
}
