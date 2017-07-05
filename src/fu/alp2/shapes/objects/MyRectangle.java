package fu.alp2.shapes.objects;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import fu.alp2.shapes.predefined.ShapeType;

/**
 * @author semmel
 *  MyRectangle....defined by a point and a height,width z.B.
 */
public class MyRectangle extends MyShape {
	protected double height;
	protected double width;

	public MyRectangle(double x, double y, double höhe, double breite) {
		super(x, y);
		this.height = höhe;
		this.width = breite;
		this.type = ShapeType.RECTANGLE;
	}

	@Override
	protected boolean equalTo(MyShape s) {
		MyRectangle r = (MyRectangle) s;
		return (Math.abs(this.height - r.height) < EPSYLON && Math.abs(this.width - r.width) < EPSYLON);
	}

	@Override
	public void change(MyShape shape) {
		MyRectangle e = (MyRectangle) shape;
		this.x = e.x;
		this.y = e.y;
		this.height = e.height;
		this.width = e.width;
	}
	@Override
	public MyRectangle clone() {
		return (MyRectangle) super.clone();
	}

	@Override
	public Shape getShape(double x, double y) {
		return (Shape) new Rectangle2D.Double(this.x + x, -this.y - this.height + y, (this.width), (this.height));
	}
}
