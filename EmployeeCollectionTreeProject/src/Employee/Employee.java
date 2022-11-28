/**
 * 
 */
package Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author vic
 * date: 08/11/2022
 * purpose: Tree Set Exercise - Employee Class
 *
 */

//use '@' to import the libraries from Lombok:
//to add the getters and setters:
@Data
//to add the default parameter:
@NoArgsConstructor
//to add the parameters constructor:
@AllArgsConstructor
//to get the 'EqualsAndHashCode' method (for memory allocation):
@EqualsAndHashCode
public class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
	private String department;
	private String role;
	private int experienceYrs;
	private int salary;
	
	//override the 'compareTo' to order the employees in experience:
	@Override
	public int compareTo(Employee employee2) {
		if(experienceYrs > employee2.experienceYrs)
			return 1;
		else if(experienceYrs < employee2.experienceYrs)
			return -1;
		else if(this.experienceYrs == employee2.experienceYrs)
			return 0;
		return 1;
	} 
	
}
