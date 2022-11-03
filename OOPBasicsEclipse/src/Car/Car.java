package Car;

/**
 *
 * @author vic
 * date: 02/11/2022
 * purpose: Car parentClass, model 'is-a'-car subClasses, driver 'has-a'-car subClass, main carRentalSystem  
 *
 */
public class Car {

	//declare the variables:
	private String model, color;

	//the constructor
	//'super' keyword allows all parent class methods to be call-able:
	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	//implement the getters (read-only) and setters (writable):
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}

	//the method:
	public void engine() {
		System.out.println("Write your own engine");
	}
}
