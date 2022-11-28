package Food;

/**
 *
 * @author vic
 * date: 23/11/2022
 * purpose: The Main Class
 *
 */
public class Main {

	public static void main(String[] args) {
		//declare a new 'Food' object and call the one of the Enums to get the food info:
		Food food = Food.PIZZA;
		//declare a new 'Food' object and call the one of the Enums to get the calorie info:
		Food calorie = Food.PIZZA;
		
		//call the 'buyFood' abstract method:
		food.buyFood();
		
		//call the 'checkCalorie' method:
		calorie.checkCalorie();
	}

}
