/**
 * 
 */
package Car;

/**
 *
 * @author vic
 * date: 02/11/2022
 * purpose: Car parentClass, model 'is-a'-car subClasses, driver 'has-a'-car subClass, main carRentalSystem 
 *
 */
public class Driver {

	//declare the read-only variable:
	private String name;
	
	//references the 'car' object in the 'Car' parentClass:
	private Car car;
	
	//the constructor
	//'super' keyword allows all parent class methods to be call-able:
	public Driver(String name) {
		super();
		this.name = name;
	}

	//implement the setter (writable):
	public void setCar(Car car) {this.car = car;}
	
	//overriding the parentClass method:
	public void drive() {
		System.out.print(name + " is driving a " + car.getColor() + " " + car.getModel() + " ");
		//calls the 'Car' parentClass's method
		car.engine();
	}

}
