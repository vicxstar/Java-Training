package Food;

/**
 *
 * @author vic
 * date: 23/11/2022
 * purpose: My Enum Class
 *
 */
//define an Enum:
//it's similar to defining a class or an interface
public enum Food {
	
	//an enum constant:
	//the enum items are constants so they should be named in all caps
	CHICKEN(700, false, 5) {
		//override the 'buyFood' method:
		@Override
		public void buyFood() {
			System.out.println("This dish is " + isVeggie() + " vegeterian, and costs " + getPrice());
		}

		//override the 'checkCalorie' method:
		@Override
		public boolean checkCalorie() {
			if (this.getCalories() > 600) {
				System.out.println("This dish has " + getCalories() + " so it is a high calorie dish");
		        return true;
			} else {
				System.out.println("This dish has " + getCalories() + " so it is a low calorie dish");
		        return false;
			}
		}
	},	
	
	//an enum constant:
	VEGETABLES(250, true, 3) {
		//override the 'buyFood' method:
		@Override
		public void buyFood() {
			System.out.println("This dish is " + isVeggie() + " vegeterian, and costs " + getPrice());
		}

		//override the 'checkCalorie' method:
		@Override
		public boolean checkCalorie() {
			if (this.getCalories() > 600) {
				System.out.println("This dish has " + getCalories() + " so it is a high calorie dish");
		        return true;
			} else {
				System.out.println("This dish has " + getCalories() + " so it is a low calorie dish");
		        return false;
			}
		}
	},
	
	//an enum constant:
	FISH(400, false, 4) {
		//override the 'buyFood' method:
		@Override
		public void buyFood() {
			System.out.println("This dish is " + isVeggie() + " vegeterian, and costs " + getPrice());
		}

		//override the 'checkCalorie' method:
		@Override
		public boolean checkCalorie() {
			if (this.getCalories() > 600) {
				System.out.println("This dish has " + getCalories() + " so it is a high calorie dish");
		        return true;
			} else {
				System.out.println("This dish has " + getCalories() + " so it is a low calorie dish");
		        return false;
			}
		}
	},
	
	//an enum constant:
	PIZZA(750, true, 15) {
		//override the 'buyFood' method:
		@Override
		public void buyFood() {
			System.out.println("This dish is " + isVeggie() + " vegeterian, and costs " + getPrice());
		}

		//override the 'checkCalorie' method:
		@Override
		public boolean checkCalorie() {
			if (this.getCalories() > 600) {
				System.out.println("This dish has " + getCalories() + " so it is a high calorie dish");
		        return true;
			} else {
				System.out.println("This dish has " + getCalories() + " so it is a low calorie dish");
		        return false;
			}
		}
		
	},
	
	//an enum constant:
	PASTA(350, true, 18) {
		//override the 'buyFood' method:
		@Override
		public void buyFood() {
			System.out.println("This dish is " + isVeggie() + " vegeterian, and costs " + getPrice());
		}

		//override the 'checkCalorie' method:
		@Override
		public boolean checkCalorie() {
			if (this.getCalories() > 600) {
				System.out.println("This dish has " + getCalories() + " so it is a high calorie dish");
		        return true;
			} else {
				System.out.println("This dish has " + getCalories() + " so it is a low calorie dish");
		        return false;
			}
		}
		
	};	
	
	//declare the variables:
	private int calories;
	private boolean veggie;
	private double price;
	
	//the getters and setters:
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public boolean isVeggie() {
		return veggie;
	}
	public void setVeggie(boolean veggie) {
		this.veggie = veggie;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//the parameters constructor:
	private Food(int calories, boolean veggie, int price) {
		this.calories = calories;
		this.veggie = veggie;
		this.price = price;
	}
	
	//the abstract methods:
	public abstract void buyFood();
	public abstract boolean checkCalorie();
}
