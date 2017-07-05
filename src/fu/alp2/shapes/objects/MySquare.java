package fu.alp2.shapes.objects;

import fu.alp2.shapes.predefined.ShapeType;

public class MySquare extends MyRectangle {

	public MySquare(double x, double y, double länge) {
		super(x, y, länge, länge);
		this.type = ShapeType.SQUARE;
	}
	@Override
	public MySquare clone() {
		return (MySquare) super.clone();
	}

}
