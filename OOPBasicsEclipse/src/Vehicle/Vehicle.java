package Vehicle;

/**
 * @author vic
 * date: 01/11/2022
 * purpose: Vehicle Class
 *
 */
public class Vehicle {

	//define properties:
    private String type;
    private String make;
    private int modelNum;
    
    //implement 'getters' and 'setters':
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getmake() {return make;}
    public void setMake(String make) {this.make = make;}
    public int getModelNum() {return modelNum;}
    public void setModelNum(int modelNum) {this.modelNum = modelNum;}
    
    
    
    //implement a constructor to initialise values:
    public void inputVehicle(String type, String make, int modelNum) {
        this.type = type;
        this.make = make;
        this.modelNum = modelNum;
    }
    
    public void displayInfo() {
        System.out.println("Your vehicle is a " + type + "; it was made by " + make + ", and the model number is " + modelNum + "."); 
    }
	
}