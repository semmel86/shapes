package fu.alp2.shapes.awt;

import java.awt.Shape;

/**
 * Interface Drawable,implementing classes could be painted by coordinateSystem.
 * 
 * @author semmel
 *
 */
public interface Drawable {
	/**
	 * return shape, dependent to the middle of window (x,y)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Shape getShape(double x, double y);
}
