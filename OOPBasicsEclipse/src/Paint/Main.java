package Paint;

/**
 *
 * @author vic
 * date: 
 * purpose: 
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//Instantiate an object of the line class:
		Line line = new Line();
		
		//add the methods from the interface it implemented:
		line.drawingColor();
		line.thickness();
		
		//Instantiate an object of the circle class:
		Circle circle = new Circle();
		
		//add the methods from the interface it implemented:
		System.out.println("===================" + '\n');
		circle.drawingColor();
		circle.thickness();
		circle.fillingColor();
		circle.size();
		
		//Instantiate an object of the square class:
		Square square = new Square();
		
		//add the methods from the interface it implemented:
		System.out.println("===================" + '\n');
		square.drawingColor();
		square.thickness();
		square.fillingColor();
		square.size();
	}

}
