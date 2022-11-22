package Calculator;

import Exception.NegativeNumberException;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The Calculator Class
 *
 */
public class Calculator {

	/*
	 * REQUIREMENT R001 - Divide 2 integers
	 */
	//import the 'NegativeNumberException' exception
	public int divide(int number1,int number2)throws NegativeNumberException {
		//an 'if' statement to check if the number is >= 0 and number is <= 0:
		if(number1 >= 0 && number2 >= 0)
			//if they are, divide them:
			return number1 / number2;
		else
			//if they are not, throw the 'NegativeNumberException' and a message to notify the user of the exception:
			throw new NegativeNumberException("Numbers cannot be Negative");
	}
	
	/*
	 * REQUIREMENT R002 - Add 2 integers
	 */
	public int add(int number1,int number2) throws NegativeNumberException{
		//an 'if' statement to check if the number is >= 0 and number is <= 0:
		if(number1 >= 0 && number2 >= 0)
			//if they are, add them:
			return number1 + number2;
		else
			//if they are not, throw the 'NegativeNumberException' and a message to notify the user of the exception:
			throw new NegativeNumberException("Numbers cannot be Negative");
	}
}
