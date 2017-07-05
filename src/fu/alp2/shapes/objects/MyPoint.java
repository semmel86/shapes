package fu.alp2.shapes.objects;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import fu.alp2.shapes.predefined.ShapeType;

public class MyPoint extends MyShape {

	public MyPoint(double x, double y) {
		super(x, y);
		this.type = ShapeType.POINT;
	}

	@Override
	public MyPoint clone() {
		return (MyPoint) super.clone();
	}

	@Override
	protected boolean equalTo(MyShape s) {
		// Punkt hat immer die gleiche Form
		return true;
	}

	@Override
	public void change(MyShape shape) {
		this.x = shape.x;
		this.y = shape.y;
	}

	@Override
	public Shape getShape(double x, double y) {
		return (Shape) new Line2D.Double(this.x + x, -this.y + y, this.x + x, -this.y + y);
	}
}
