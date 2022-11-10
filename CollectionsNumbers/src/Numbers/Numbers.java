package Numbers;

/**
*
* @author vic
* date: 07/11/2022
* purpose: Collections Exercise - Numbers Class
*
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//use '@' to import the libraries from Lombok:
//to add the getters and setters:
@Data
//to add the default parameter:
@NoArgsConstructor
//to add the parameters constructor:
@AllArgsConstructor
//to get the 'EqualsAndHashCode' method (for memory allocation):
@EqualsAndHashCode
public class Numbers {

	//declare the variable:
	private int num;
	private int index;
}
