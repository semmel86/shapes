package fu.alp2.shapes.objects;

import fu.alp2.shapes.predefined.ShapeType;

public class MySquare extends MyRectangle {

	public MySquare(double x, double y, double l�nge) {
		super(x, y, l�nge, l�nge);
		this.type = ShapeType.SQUARE;
	}
	@Override
	public MySquare clone() {
		return (MySquare) super.clone();
	}

}
