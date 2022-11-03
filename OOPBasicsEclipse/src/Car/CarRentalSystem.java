package Car;

/**
*
* @author vic
* date: 02/11/2022
* purpose: Car parentClass, model 'is-a'-car subClasses, driver 'has-a'-car subClass, main carRentalSystem 
*
*/
public class CarRentalSystem {

	public static void main(String[] args) {
		
		//instantiate a new 'audi' object:
		Audi audi=new Audi("A8", "Red"); //feed the parameters (model, colour( into it
		
		//instantiate a new 'mercedes' object:
		Mercedes mercedes=new Mercedes("M15", "Silver"); //feed the parameters (model, colour) into it
		
		//instantiate a new 'driver' object:
		Driver john=new Driver("John"); //feed the parameters (name) into it
		Driver alex=new Driver("Alex"); //feed the parameters (name) into it
		
		//set the 'mercedes' object into the 'driver' object
		john.setCar(mercedes);
		//call the drive constructor which implements the 'Car' method:
		john.drive();

		//set the 'audi' object into the 'driver' object
		alex.setCar(audi);
		//call the drive constructor which implements the 'Car' method:
		alex.drive();
	}

}
