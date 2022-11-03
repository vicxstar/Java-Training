package Person;

/**
 *
 * @author vic
 * date: 03/11/2022
* purpose: Entrepreneur Class - Entrepreneur 'is-a' person
 *
 */
public class Entrepreneur extends Person {

	private String natureOdBusiness;
	private double turnOver;
	
	public Entrepreneur() {
		
	}

	public Entrepreneur(int id, String name, int age, String natureOdBusiness, double turnOver) {
		super(id, name, age);
		this.natureOdBusiness = natureOdBusiness;
		this.turnOver = turnOver;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Nature of Bussiness : "+natureOdBusiness);
		System.out.println("TurnOver : "+turnOver);
	}
}
