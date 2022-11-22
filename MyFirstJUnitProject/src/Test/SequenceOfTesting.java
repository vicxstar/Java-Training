/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The Sequence of Testing
 *
 */
class SequenceOfTesting {

	//1. the first run in the sequence:
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("1. setUpBefore Class");
	}

	//8. the last run in the sequence:
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("2. TearDownAfterClass");
	}

	//no. 2 in the sequence:
	//no. 5 in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("a. setUp");
	}

	//no. 4 in the sequence:
	//no. 7 in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("b. tearDown");
	}

	//no. 3 in the sequence:
	@Test
	void testDivide1() {
		System.out.println("Test Case 1");
	}
	
	//no. 6 in the sequence:
	@Test
	void testDivide2() {
		System.out.println("Test Case 2");
	}

}
