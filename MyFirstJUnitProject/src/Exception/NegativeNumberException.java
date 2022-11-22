package Exception;

/**
 *
 * @author vic
 * date: 21/11/2022
 * purpose: The Exception Class
 *
 */

//extends the 'Exception' parent class:
public class NegativeNumberException extends Exception {

	public NegativeNumberException(String message) {
		super(message);
	}
	
}
