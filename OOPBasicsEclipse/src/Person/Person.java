/**
 * 
 */
package Person;

/**
 *
 * @author vic
 * date: 02/11/2022
 * purpose: Person Class
 *
 */
public class Person {

	//declare the variables:
	private String name;
	private int id, age;
	
	//the 'Person' constructor:
	public Person() {
	}
	
	//the constructor:
	public Person(int id,String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	//implement the getters (read-only) and setters (writable):
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	//the method:
	public void display() {
		System.out.println("Your ID is : " + id);
		System.out.println("Your name : " + name);
		System.out.println("Your age : " + age);
	}
}
