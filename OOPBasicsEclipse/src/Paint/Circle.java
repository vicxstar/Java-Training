package Paint;

/**
*
* @author vic
* date: 03/11/2022
* purpose: Paint Exercise - Circle can be drawn and filled so implementing those interfaces
*
*/
public class Circle implements Drawable, Fillable{

	//overrides the method from the 'Fillable' interface:
	@Override
	public void fillingColor() {
		System.out.println("This circle is filled with the colour pink");
		
	}

	//overrides the method from the 'Fillable' interface:
	@Override
	public void size() {
		System.out.println("It is a medium sized circle");
		
	}

	//overrides the method from the 'Drawable' interface:
	@Override
	public void drawingColor() {
		System.out.println("This circle outlined is red");
		
	}

	//overrides the method from the 'Drawable' interface:
	@Override
	public void thickness() {
		System.out.println("It is 1cm thick");
		
	}

}
