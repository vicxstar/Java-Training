/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import Calculator.Calculator;
import Exception.NegativeNumberException;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The Calculator Testing Class
 *
 */
//can use '@DisplayName()' to name the test class:
@DisplayName("Calculator Testing Class")
class TestCalculator {
	
	//declare and instantiate a new 'Calculator' object called 'calc':
	//import it:
	Calculator calc;
	
	//the first run in the sequence:
	@BeforeEach
	void setUp() throws Exception {
		//declare a new 'Calculator' object:
		calc = new Calculator();
	}

	//the last run in the sequence:
	@AfterEach
	void tearDown() throws Exception {
		calc = null;
	}

	//import 'NegativeNumberException'
	//a test sequence:
	//can use '@DisplayName()' to name the test sequences:
	@DisplayName("Testing: 20/5")
	@Test
	void R001_T001() throws NegativeNumberException {
		assertEquals(4, calc.divide(20, 5));
	}
	
	//a test sequence:
	@DisplayName("Testing -20/5")
	@Test
	void R001_T002() throws NegativeNumberException {
		assertThrows(NegativeNumberException.class,() -> calc.divide(-20, 5));
	}
	
	//a test sequence:
	@DisplayName("Testing: 20/-5")
	@Test
	void R001_T003() throws NegativeNumberException {
		assertThrows(NegativeNumberException.class,() -> calc.divide(20, -5));
	}
	
	//a test sequence:
	@DisplayName("Testing: -20/-5")
	@Test
	void R001_T004() throws NegativeNumberException {
		assertThrows(NegativeNumberException.class,() -> calc.divide(-20, -5));
	}
	
	//a test sequence:
	@DisplayName("Testing: 0/5")
	@Test
	void R001_T005() throws NegativeNumberException {
		assertEquals(0, calc.divide(0, 5));
	}
	
	//a test sequence:
	@DisplayName("Testing: 20/0")
	@Test
	void R001_T006() throws NegativeNumberException {
		assertThrows(ArithmeticException.class,() -> calc.divide(20, 0));
	}
	
	//'@Nested' is used to signal that the annotated class is a nested, non-static test class (an inner class)
	//import '@Nested'
	@Nested
	class CheckAdd {
		//a test sequence:
		@DisplayName("Testing: 20 + 5")
		@Test
		void R002_T001() throws NegativeNumberException {
			assertEquals(25, calc.add(20, 5));
		}

		//a test sequence:
		@DisplayName("Testing: -20 + 0")
		@Test
		void R002_T002() throws NegativeNumberException {
			assertThrows(NegativeNumberException.class, () -> calc.add(-20, 5));
		}

		//a test sequence:
		@DisplayName("Testing: 20 + -5")
		@Test
		void R002_T003() throws NegativeNumberException {
			assertThrows(NegativeNumberException.class, () -> calc.add(20, -5));
		}

		//a test sequence:
		@DisplayName("Testing: -20 + -5")
		@Test
		void R002_T004() throws NegativeNumberException {
			assertThrows(NegativeNumberException.class, () -> calc.add(-20, -5));
		}

		//a test sequence:
		@DisplayName("Testing: 0 + 5")
		@Test
		void R002_T005() throws NegativeNumberException {
			assertEquals(5, calc.add(0, 5));
		}

		//a test sequence:
		@DisplayName("Testing: 20 + 0")
		@Test
		void R002_T006() throws NegativeNumberException {
			assertEquals(20, calc.add(20, 0));
		}
	}
}
