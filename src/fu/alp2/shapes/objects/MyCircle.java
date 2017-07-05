package fu.alp2.shapes.objects;

import fu.alp2.shapes.predefined.ShapeType;

public class MyCircle extends MyElypse {

	public MyCircle(double x, double y, double r) {
		super(x, y, r, r);
		this.type = ShapeType.CIRCLE;
	}

	@Override
	protected boolean equalTo(MyShape s) {
		MyCircle c = (MyCircle) s;
		if ((this.vradius - c.vradius) < EPSYLON) {
			return true;
		}
		return false;
	}
	
	@Override
	public MyCircle clone() {
		return (MyCircle) super.clone();
	}
}
