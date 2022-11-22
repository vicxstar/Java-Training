package MyFirstStreamProject;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vic
 * date: 18/11/2022 (continued on 21/11/2022)
 * purpose: Stream and Lambdas
 *
 */
public class MyFirstStreamProject {

	public static void main(String[] args) {
		
		//declare a list (type = integer) called 'list':
		//import 'List' and 'Arrays'
		//'.asList()' is the function of the 'Arrays' class
		List<Integer> numbers = Arrays.asList(2, 13, 24, 36, 48, -53, -65, -77, 84, -90);
		
		//'stream' is an API used to process collections of objects
		//'.count()' returns the number of elements in the 'stream'
		//print out the number of elements in the stream:
		System.out.println("There are " + numbers.stream().count() + " numbers in the list:");
		numbers.stream()
		.forEach(t -> System.out.print(t + " "));
		System.out.println("\n");
		
		//'.count()' returns 'long' objects so make the object a long:
		//use '.filter()' to filter to the data to return specific results:
		//to count how many objects in the stream are negative, using 'lambda' (->):
		long tNoN = numbers.stream().filter((n) -> n < 0).count();
		
		//print out the number of negative elements in the stream:
		System.out.print(tNoN + " of them are negative");
		System.out.println("\n");
		
		//print a statement:
		System.out.println("Those negative numbers are now positive: ");
		//call '.stream() to the 'numbers' list to process the list:
		numbers.stream()
		//use '.filter()' to filter to the data to return specific results:
		.filter((n) -> n < 0)
		//use the '.map()' function to manipulate the data to return specific results:
		.map(element -> element * -1)
		//use '.forEach()' to apply the actions from '.map()' to (for) each element in the list:
		.forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		
		System.out.println("All numbers in the list are now positive: ");
		//a loop to convert the negative elements into positive elements and to print all the elements in the list:
		//first a list:
		List<Integer> nums = Arrays.asList(2, 13, 24, 36, 48, -53, -65, -77, 84, -90);
		//call '.stream() to the 'numbers' list to process the list:
		nums.stream()
		//use the '.map()' function to manipulate the data to return specific results:
		.map(n -> {
			//an 'if' statement to check if the numbers < 0:
			if(n < 0)
				//if they are, multiply them by -1 (to turn them positive):
				n = n * -1;
			//if they are not then return them:
			return n;
			}
		//use '.forEach()' to apply the actions from '.map()' to (for) each element in the list:
		).forEach(n -> System.out.print(n + " "));
	}

}
