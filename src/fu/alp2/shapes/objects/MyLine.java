package fu.alp2.shapes.objects;

import java.awt.Shape;
import java.awt.geom.Line2D;

import fu.alp2.shapes.predefined.ShapeType;

public class MyLine extends MyShape {

	private double x2;
	private double y2;

	public MyLine(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
		this.type = ShapeType.LINE;
	}

	@Override
	public MyLine clone() {
		return (MyLine) super.clone();

	}

	@Override
	protected boolean equalTo(MyShape s) {
		// Punkt hat immer die gleiche Form
		return true;
	}

	@Override
	public void change(MyShape shape) {
		MyLine e = (MyLine) shape;
		this.x = e.x;
		this.y = e.y;
		this.y2 = e.y2;
		this.x2 = e.x2;
	}

	@Override
	public Shape getShape(double x, double y) {
		return (Shape) new Line2D.Double(this.x + x, -this.y + y, this.x2 + x, -this.y2 + y);
	}
}
