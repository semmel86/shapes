package fu.alp2.shapes.objects;

import java.awt.Shape;

import fu.alp2.shapes.awt.Drawable;
import fu.alp2.shapes.predefined.ShapeType;

public abstract class MyShape implements Cloneable, Drawable {
	protected final static double EPSYLON = Math.pow(10, 10);
	protected double x;
	protected double y;
	protected ShapeType type;
	protected Shape shape;

	public ShapeType getShapeType() {
		return this.type;
	}

	public abstract void change(MyShape shape);

	@Override
	public MyShape clone() {
		try {
			return (MyShape) super.clone();
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}
		return null;

	}

//	public void changeKoords(double x, double y) {
//		this.x = x;
//		this.y = y;
//
//	}

	public MyShape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		MyShape s = null;
		try {
			s = (MyShape) other;
		} catch (ClassCastException e) {
			// nothing to do, except to mention they are not equal
			return false;
		}
		if (this.type.equals(s.getShapeType())) {
			// Beide Shapes des gleichen Typs
			return this.equalTo(s);
		}
		return false;
	}

	// konkreter Test auf Gleichheit
	protected abstract boolean equalTo(MyShape s);

	@Override
	public String toString() {
		return type.toString() + " X: " + x + " Y: " + y;
	}
}
