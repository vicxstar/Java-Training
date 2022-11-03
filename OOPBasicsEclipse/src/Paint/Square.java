package Paint;

/**
 *
 * @author vic
 * date: 03/11/2022
 * purpose: Paint Exercise - Square can be drawn and filled so implementing those interfaces
 *
 */
public class Square implements Drawable, Fillable{

	//overrides the method from the 'Fillable' interface:
	@Override
	public void fillingColor() {
		System.out.println("This square is filled with the colour light blue");
		
	}

	//overrides the method from the 'Fillable' interface:
	@Override
	public void size() {
		System.out.println("It is a large sized square");
		
	}

	//overrides the method from the 'Drawable' interface:
	@Override
	public void drawingColor() {
		System.out.println("This square is outlined dark blue");
		
	}

	//overrides the method from the 'Drawable' interface:
	@Override
	public void thickness() {
		System.out.println("It is 1.5cm thick");
		
	}

}
