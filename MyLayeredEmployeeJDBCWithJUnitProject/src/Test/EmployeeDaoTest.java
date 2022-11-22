package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Persistence.EmployeeDaoImpl;

/**
*
* @author vic
* date: 21/11/2022
* purpose: The EmployeeDaoImpl Testing Class
*
*/
//can use '@DisplayName()' to name the test class:
@DisplayName("EmployeeDaoImpl Test")
class EmployeeDaoTest {
	
	//declare and instantiate a new 'EmployeeDaoImpl' object called 'empD':
	//import it:
	EmployeeDaoImpl  empD;

	//the first run in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		//declare a new 'EmployeeDaoImpl' object:
		empD = new EmployeeDaoImpl();
	}
	
	//the last run in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		empD = null;
	}

	@DisplayName("Get All Records Test")
	@Test
	void testGetAllRecords() {
		fail("Not yet implemented");
	}

}
