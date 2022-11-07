package Student;

/**
 *
 * @author vic
 * date: 04/11/2022
 * purpose: Student Class
 *
 */
public class Student {

	//declare the variables:
	private int rollNo;
	private int age;
	private String name;
	private double marks;
	
	//the default constructor:
	public Student() {
		
	}

	//the parameters constructor:
	public Student(int rollNo, int age, String name, double marks) throws AgeException, MarksException {
//		super();
		this.name = name;
		this.rollNo = rollNo;
		//exception method if age < 4:
		if(age >= 4 && age <= 18) {
			this.age = age;
		} else
			throw new AgeException("Student must be aged between 4 and 18 to attend this school.");
		//exception method if marks > 100:
		if(marks > 0 && marks < 100) {
			this.marks = marks;
		} else
			throw new MarksException("The marks must be between 0 and 100");
	}

	//the getters and setters:
	public int getRollNo() {return rollNo;}
	public void setRollNo(int rollNo) {this.rollNo = rollNo;}
	public int getAge() {return age;}
	
	public void setAge(int age) throws AgeException {
		//exception method if age > 18:
		if(age >= 4 && age <= 18) {
			this.age = age;
		} else
			throw new AgeException("Student must be aged between 4 and 18 to attend this school.");
		}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public double getMarks() {return marks;}
	
	//exception method for marks > 100:
	public void setMarks(double marks) throws MarksException {
		//exception method if marks > 100:
		if(marks > 0 && marks < 100) {
			this.marks = marks;
		} else
				throw new MarksException("The marks be between 0 and 100");
			}
	
	//the display method:
		public void display() {
			System.out.println("Student's roll number is : " + rollNo);
			System.out.println("Student's name is : " + name);
			System.out.println("Student's age is : " + age);
			System.out.println("Student's marks are : " + marks);
		}
}
