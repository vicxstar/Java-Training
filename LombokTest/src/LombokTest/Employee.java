package LombokTest;

/**
*
* @author vic
* date: 07/11/2022
* purpose: Lombok Employee Class
*
*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//use '@' to import the libraries from Lombok:
//to add the getters and setters:
@Data
//to add the default parameter:
@NoArgsConstructor
//to add the parameters constructor:
@AllArgsConstructor
//to get the 'ToString' method:
@ToString
//to get the 'EqualsAndHashCode' method (for memory allocation):
@EqualsAndHashCode
public class Employee {

	private int eId;
	private String eName;
	private String designation;
	private String dept;
	private double salary;

}
