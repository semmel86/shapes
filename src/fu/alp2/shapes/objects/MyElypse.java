package fu.alp2.shapes.objects;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import fu.alp2.shapes.predefined.ShapeType;

public class MyElypse extends MyShape {
	protected double hradius;
	protected double vradius;

	public MyElypse(double x, double y, double hr, double vr) {
		super(x, y);
		this.hradius = hr;
		this.vradius = vr;
		this.type = ShapeType.ELYPSE;
	}

	@Override
	protected boolean equalTo(MyShape s) {
		MyElypse c = (MyElypse) s;
		if (Math.abs(this.hradius - c.hradius) < EPSYLON && Math.abs(this.vradius - c.vradius) < EPSYLON) {
			return true;
		}
		return false;
	}

	@Override
	public void change(MyShape shape) {
		MyElypse e = (MyElypse) shape;
		this.x = e.x;
		this.y = e.y;
		this.hradius = e.hradius;
		this.vradius = e.vradius;
	}

	@Override
	public MyElypse clone() {
		return (MyElypse) super.clone();
	}

	@Override
	public Shape getShape(double x, double y) {
		return (Shape) new Ellipse2D.Double(this.x - this.vradius + x, -this.y - this.hradius + y, this.vradius * 2,
				this.hradius * 2);
	}
}
