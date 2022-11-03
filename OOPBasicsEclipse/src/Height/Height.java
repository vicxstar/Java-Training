package Height;

/**
 * @author vic
 * date: 01/11/2022
 * purpose: Height Exercise - Getting the heights
 *
 */
public class Height {

	//declare the variables:
	private int feet, inches;
	//totalFeet, totalInches,

	//implement the getters (read-only) and setters (writable):
	public int getFeet() { return feet;}
	public void setFeet(int feet) {this.feet = feet;}
	public int getInches() {return inches;}
	public void setInches(int inches) {this.inches = inches;}
	
	//the calculation method:
	public void sum(Height h1, Height h2) {
		//declare new variables to store values:
		int feetSum, inchesSum; 
		feetSum = h1.getFeet() + h2.getFeet();
	    inchesSum = h1.getInches() + h2.getInches();
	   	
	    //an enhanced 'if' statement:
	   	if(inchesSum>12) {
	   		feetSum += 1;
	   		inchesSum -= 12;
	   	}
	   	//print the results:
	   	System.out.println("The sum of the two height inputs is " + feetSum + " feet and " + inchesSum + " inches.");   		
	}
}
