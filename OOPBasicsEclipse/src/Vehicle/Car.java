package Vehicle;

/**
 * @author vic
 * date: 01/11/2022
 * purpose: Car Class
 *
 */
public class Car extends Vehicle {
	
	//define properties:
    private String colour;
    private int noOfDoors;
    private int noOfWheels;
    
    //the getters and setters:
    public String getColour() {return colour;}
    public void setColour(String colour) {this.colour = colour;}
    public int getNoOfDoors() {return noOfDoors;}
    public void setNoOfDoors(int noOfDoors) {this.noOfDoors = noOfDoors;}
    public int getNoOfWheels() {return noOfWheels;}
    public void setNoOfWheels(int noOfWheels) {this.noOfWheels = noOfWheels;}
    
    //the constructor
	public void inputCarDetails(String type, String make, int modelNum, String colour, int noOfDoors, int noOfWheels) {
		inputVehicle(type, make, modelNum);
		this.colour = colour;
        this.noOfDoors = noOfDoors;
        this.noOfWheels = noOfWheels;
	}
	
	//the method:
	public void displayCarDetails() {
//		displayInfo();
		System.out.println("It is " + colour + ", it has " + noOfDoors + " doors and " + noOfWheels + " wheels.");
	}

}