package Student;

/**
 *
 * @author vic
 * date: 04/11/2022
 * purpose: Student Roll Number List Class
 *
 */
public class RollList {

	//declare the variables:
	//Instantiate an arrayed object of the 'Student' class:
	private Student[] rollList;
	private int totalRoll;
	
	//the parameters constructor:
	public RollList( int totalRoll) {
		super();
		this.totalRoll = totalRoll;
		rollList = new Student[totalRoll];
	}
	
	//method to check the roll numbers inputed:
	public void inputRollNo(Student student, int index) throws RollNoException {
		//an enhanced 'for' loop:
		for(int i = 0; i < index; i++) {
			if(rollList[i].getRollNo() == student.getRollNo())
				//the exception method for roll number:
				throw new RollNoException("This roll number has already been inputed.");
		}
		
		rollList[index] = student;
	}
	
	//the display method:
	public void displayRollNo() {
		for(Student stu : rollList)
			stu.display();
	}
}
