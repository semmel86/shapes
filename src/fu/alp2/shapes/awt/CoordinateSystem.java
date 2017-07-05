package fu.alp2.shapes.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.util.List;

import fu.alp2.shapes.objects.MyShape;

/**
 * @author semmel Shapes-View
 * 
 * To draw into this frame, the class needs to implement the Drawable interface
 */
public class CoordinateSystem extends Frame {

	private static final long serialVersionUID = 5766559672783937148L;
	// shapes to draw
	private List<Drawable> shapes;
	// default sizes 800x800
	private int height = 800;
	private int width = 800;

	// constructor
	public CoordinateSystem(List<Drawable> shapes) {
		this.shapes = shapes;

		// get screensize
		Toolkit tk = this.getToolkit();
		this.height = tk.getScreenSize().height;
		this.width = tk.getScreenSize().width;
		// set frame size
		this.setBounds(0, 0, width, height);
		this.setVisible(true);
		// add windowlistener for close
		this.addWindowListener(new TestWindowListener());
	}

	public void paint(Graphics g1) {

		// draw Frame
		Graphics2D g = (Graphics2D) g1;
		Shape vertical = new Line2D.Double(width / 2, 0, width / 2, height);
		Shape horizontal = new Line2D.Double(0, height / 2, width, height / 2);
		g.draw(vertical);
		g.draw(horizontal);

		// Y-Achse
		g.drawString("y= -" + String.valueOf(height / 2), width / 2 - 50, height - 20);
		g.drawString("0", width / 2 - 50, height / 2 + 20);
		g.drawString("y= +" + String.valueOf(height / 2), width / 2 - 50, +50);

		// x-Achse
		g.drawString("x= +" + String.valueOf(width / 2), width - 50, height / 2 + 20);
		g.drawString("x= -" + String.valueOf(width / 2), +20, height / 2 + 20);
		for (Drawable shape : shapes) {
			Shape s = shape.getShape(width / 2, height / 2);

			// draw shape
			g.setStroke(new BasicStroke(5));
			g.setColor(getRandomColor());
			g.draw(s);

		}
	}

	// random rgb-color generator
	private Color getRandomColor() {
		int red = (int) (1 + Math.random() * 255);
		int green = (int) (1 + Math.random() * 255);
		int blue = (int) (1 + Math.random() * 255);
		Color color = new Color(red, green, blue);
		if ((red + green + blue) > 25) {
			// gute Farbe
			System.out.println("RGB: {" + red + "," + green + "," + blue + "}");
			return color;

		} else {
			// zu helle Farbe
			return getRandomColor();
		}
	}

	// Listener
	private class TestWindowListener extends WindowAdapter {
		// listen on Close, if so -> exit
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose();
			System.exit(0);
		}
	}

	// set shapes
	public void setShapes(List<Drawable> shapes) {
		this.shapes = shapes;
		this.repaint();

	}

	// ad single shape
	public void addShape(MyShape shape) {
		this.shapes.add(shape);
		this.repaint();
	}
}
