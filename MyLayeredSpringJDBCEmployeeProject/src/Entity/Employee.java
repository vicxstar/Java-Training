package Entity;

import java.time.LocalDate; //better than using 'sql.date' or 'util.date'

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 1. The ENTITY class
 *
 */

//use '@' to import the libraries from Lombok:
//to add the getters and setters:
@Data
//to add the default parameter:
@NoArgsConstructor
//to add the parameters constructor:
@AllArgsConstructor
//to get the 'ToString' method:
@ToString
public class Employee {

	//declare the variables:
	private int empId;
	private String empFirstName;
	private String empLastName;
	private String empEmail;
	private String empPhoneNum;
	private LocalDate hireDate;
	private String jobId;
	private double empSalary;
	private double empCommission;
	private int managerId;
	private int departmentId;
	private String departmentName;
}
