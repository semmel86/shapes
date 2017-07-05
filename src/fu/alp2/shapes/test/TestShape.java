package fu.alp2.shapes.test;

import org.junit.Before;
import org.junit.Test;

import fu.alp2.shapes.objects.MyCircle;
import fu.alp2.shapes.objects.MyElypse;
import fu.alp2.shapes.objects.MyLine;
import fu.alp2.shapes.objects.MyPoint;
import fu.alp2.shapes.objects.MyRectangle;
import fu.alp2.shapes.objects.MySquare;
import fu.alp2.shapes.predefined.ShapeType;
import junit.framework.TestCase;

public class TestShape {
	MyPoint point;
	MyCircle circle;
	MyRectangle rectangle;
	MySquare square;
	MyElypse elypse;
	MyLine line;

	@Before
	public void init() {
		// so each test starts with the same values regardless to the test order
		point = new MyPoint(2, 2);
		circle = new MyCircle(400, 400, 200);
		rectangle = new MyRectangle(200, 100, 133, 550);
		square = new MySquare(50, 50, 200);
		elypse = new MyElypse(400, 400, 10, 50);
		line = new MyLine(0, 0, 600, 600);
	}

	/**
	 * Test the clonable functionality
	 */
	@Test
	public void testClone() {
		MyPoint point2 = point.clone();
		MySquare square2 = square.clone();
		MyCircle circle2 = circle.clone();
		MyRectangle rectangle2 = rectangle.clone();
		MyElypse elypse2 = elypse.clone();
		MyLine line2 = line.clone();
		// they should be equal...
		TestCase.assertEquals(point2, point);
		TestCase.assertEquals(square2, square);
		TestCase.assertEquals(circle2, circle);
		TestCase.assertEquals(rectangle2, rectangle);
		TestCase.assertEquals(elypse2, elypse);
		TestCase.assertEquals(line2, line);
		// but not the same object
		TestCase.assertNotSame(point.hashCode(), point2.hashCode());
		TestCase.assertNotSame(square.hashCode(), square2.hashCode());
		TestCase.assertNotSame(circle.hashCode(), circle2.hashCode());
		TestCase.assertNotSame(rectangle.hashCode(), rectangle2.hashCode());
		TestCase.assertNotSame(elypse.hashCode(), elypse2.hashCode());
		TestCase.assertNotSame(line.hashCode(), line2.hashCode());
	}

	/**
	 * Test the equal() functionality
	 */
	@Test
	public void testEqual() {
		MyPoint point2 = point.clone();
		MySquare square2 = square.clone();
		MyCircle circle2 = circle.clone();
		MyRectangle rectangle2 = rectangle.clone();
		MyElypse elypse2 = elypse.clone();
		MyLine line2 = line.clone();
		// they should be equal..-> equal==true
		TestCase.assertEquals(point2.equals(point), true);
		TestCase.assertEquals(square2.equals(square), true);
		TestCase.assertEquals(circle2.equals(circle), true);
		TestCase.assertEquals(rectangle2.equals(rectangle), true);
		TestCase.assertEquals(elypse2.equals(elypse), true);
		TestCase.assertEquals(line2.equals(line), true);
	}

	/**
	 * Test the change-method
	 * 
	 * Expect a different Location for the Object but the Object should be the
	 * same
	 */
	@Test
	public void testChanges() {
		int idBefore = point.hashCode();
		MyPoint oldPoint = point.clone();
		point.change(new MyPoint(50, 50));
		int idAfter = point.hashCode();
		TestCase.assertEquals(idBefore, idAfter);
		TestCase.assertEquals(point.equals(oldPoint), true);
	}
	
	/**
	 * Test the correct ShapeTypes
	 */
	@Test
	public void testShapeTypes(){
		TestCase.assertEquals(point.getShapeType(), ShapeType.POINT);
		TestCase.assertEquals(square.getShapeType(), ShapeType.SQUARE);
		TestCase.assertEquals(circle.getShapeType(), ShapeType.CIRCLE);
		TestCase.assertEquals(rectangle.getShapeType(), ShapeType.RECTANGLE);
		TestCase.assertEquals(elypse.getShapeType(), ShapeType.ELYPSE);
		TestCase.assertEquals(line.getShapeType(), ShapeType.LINE);
	}

}
