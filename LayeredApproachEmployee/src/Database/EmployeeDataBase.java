package Database;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Employee;

/**
 *
 * @author vic
 * date: 09/11/2022
 * purpose: Step 2. The DATABASE
 *
 */
public class EmployeeDataBase {

	//Initialise a linked has map:
	//import 'map', 'hashmap' and the entity 'Employee':
	static private Map<Integer, Employee> employeeList=new LinkedHashMap<Integer, Employee>();
	
	//put values into 'employeeList':
	static {
		employeeList.put(101, new Employee(101, "AAAA", "Executive", "IT", 12000));
		employeeList.put(102, new Employee(102, "BBBB", "Associate", "IT", 93000));
		employeeList.put(103, new Employee(103, "CCCC", "Sr. Executive", "Purchase", 18000));
		employeeList.put(104, new Employee(104, "DDDD", "Manager", "IT", 62000));
		employeeList.put(105, new Employee(105, "EEEE", "Sr. Manager", "Sales", 78000));
	}
	
	//create another map to get the list:
	public static Map<Integer, Employee> getEmployeeList() {
		return employeeList;
	}
}
