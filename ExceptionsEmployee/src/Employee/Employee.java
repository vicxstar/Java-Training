package Employee;

/**
 *
 * @author vic
 * date: 04/11/2022
 * purpose: Employee Class
 *
 */
public class Employee {

	//declare variables
	private String name;
	private int age;
	
	//the default constructor:
	public Employee() {
		
	}
	
	//the parameters constructor:
	public Employee(String name, int age) throws AgeException {
//		super();
		if(age >= 18 && age <= 60) {
			this.name = name;
			this.age = age;
		} else
			throw new AgeException("Age must be between 18 and 60");
	}
		
	//the getters and setters:
	public String getName() {return name;}
	public void setName(String name){this.name = name;}
	public int getAge() {return age;}
	
	public void setAge(int age)throws AgeException {
		if (age >= 18 && age <= 60) {
			this.age = age;
		}
		else
			throw new AgeException("Age must be between 18 to 60");
	}

	//the display method:
	public void display() {
		System.out.println("Employee's name is : " + name);
		System.out.println("Employee's age is : " + age);
	}
}
