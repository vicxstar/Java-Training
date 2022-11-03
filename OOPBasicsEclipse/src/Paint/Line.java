package Paint;

/**
 *
 * @author vic
 * date: 03/11/2022
 * purpose: Paint Exercise - Line can only be drawn and filled so implementing that interfaces
 *
 */
public class Line implements Drawable{

	//overrides the method from the 'Drawable' interface:
	@Override
	public void drawingColor() {
		System.out.println("This line is blue");
		
	}

	//overrides the method from the 'Drawable' interface:
	@Override
	public void thickness() {
		System.out.println("It is 0.5cm thick");
		
	}

	
}
