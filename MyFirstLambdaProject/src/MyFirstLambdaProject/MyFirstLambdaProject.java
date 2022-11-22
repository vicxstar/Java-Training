package MyFirstLambdaProject;

/**
 *
 * @author vic
 * date: 18/11/2022
 * purpose: Lambda
 *
 */

//declare an interface:
//use the '@FunctionalInterface' annotation so that you can make use of 'Lambda':
@FunctionalInterface
interface Operator{
	
	//the single abstract method:
	int perform(int number1,int number2);
}

public class MyFirstLambdaProject {
	
	public static void main(String[] args) {
		
		//the 'lambda' method (->):
		Operator diff = (number1,number2) -> number1-number2;
		
		//print the result:
		//add the numbers:
		System.out.println("Sum = " + diff.perform(10, 30));

	}

}
