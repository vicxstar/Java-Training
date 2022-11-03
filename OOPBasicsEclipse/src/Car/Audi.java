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
public class Audi extends Car{

	//the constructor:
	//getting the parentClass methods via 'super':
	public Audi(String model, String color) {
		super(model, color);
	}
	
	//overriding the parentClass method:
	@Override
	public void engine() {
		System.out.println("Audi. The engine goes BOOOOM.....");
	}


}
