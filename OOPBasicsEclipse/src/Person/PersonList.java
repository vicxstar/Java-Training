package Person;

/**
*
* @author vic
* date: 02/11/2022
* purpose: Person List Class - personList 'has-a' people
*
*/
public class PersonList {

	//declare an array variable:
	private Person[] people;
	
	//declare a variable:
	private int totalNoPeople;
	
	//the constructor:
	public PersonList(int totalNoPeople) {
		this.totalNoPeople = totalNoPeople;
		//instantiate a new array of the 'people' variable and put the int 'totalNoPeople' into it:
		people=new Person[totalNoPeople];
	}
	
	//the methods:
	//to input into the list:
	public void inputPerson(Person person,int index) {
		people[index] = person;
	}
	
	//to display the list:
	public void displayPersonList() {
		//an enhanced 'for' loop to get the 'totalNoPeople':
		for(int index=0;index<totalNoPeople;index++) {
			System.out.println("The ID number is: " + people[index].getId() + ", the name is: " + people[index].getName() + ", their age is: "+people[index].getAge());
		}
	}
}
