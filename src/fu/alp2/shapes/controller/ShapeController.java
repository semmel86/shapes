package fu.alp2.shapes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fu.alp2.shapes.awt.Drawable;
import fu.alp2.shapes.awt.CoordinateSystem;
import fu.alp2.shapes.objects.MyCircle;
import fu.alp2.shapes.objects.MyElypse;
import fu.alp2.shapes.objects.MyLine;
import fu.alp2.shapes.objects.MyPoint;
import fu.alp2.shapes.objects.MyRectangle;
import fu.alp2.shapes.objects.MyShape;
import fu.alp2.shapes.objects.MySquare;
import fu.alp2.shapes.predefined.ShapeType;

/**
 * Service Class containing the main()-Method
 * The main is the only visible and accessible method.
 * All including private methods are tested by UAT
 * 
 * @author semmel
 * 
 */
public class ShapeController {
	private static List<Drawable> shapes = new ArrayList<Drawable>();
	private static CoordinateSystem ks = new CoordinateSystem(shapes);

	// good old main
	public static void main(String args[]) {
		boolean runIt = true;
		while (runIt) {
			runIt = run();
		}
	}

	// runs the application
	private static boolean run() {

		// Ask for Type
		String[] options = { "Form Zufügen", "Form Löschen", "Form Ändern", "Beenden" };
		String todo = (String) JOptionPane.showInputDialog(null, "Was möchten Sie tun?", "Forminator_v.1.0",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (todo == null || todo.isEmpty() || todo.equals("Beenden")) {
			return false;
		} else if (todo.equals("Form Zufügen")) {
			return addForm();
		} else if (todo.equals("Form Löschen")) {
			return removeShape(chooseForm());
		} else if (todo.equals("Form Ändern")) {
			return changeShape(chooseForm());
		} else {
			return false;
		}

	}

	// search a form from list. (e.g. for editing or deleting it)
	private static MyShape chooseForm() {
		MyShape[] choices = new MyShape[shapes.size() + 1];
		choices = shapes.toArray(choices);
		MyShape toRemove = (MyShape) JOptionPane.showInputDialog(null, "Welche Form möchten Sie bearbeiten?",
				"Forminator_v.1.0", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		if (toRemove == null) {
			return null;
		} else {
			return toRemove;
		}

	}

	// add a shape to list, includes repainting
	private static void addShape(MyShape s) {
		if(s!=null){
		shapes.add(s);
		ks.repaint();
		}
	}

	// removes a shape from List, includes repainting
	private static boolean removeShape(MyShape toRemove) {
		if (toRemove != null) {
			shapes.remove(toRemove);
			ks.repaint();
			return true;
		} else {
			return false;
		}
	}

	// change an existing shape, includes repainting
	private static boolean changeShape(MyShape toChange) {
		MyShape newShape=getShape(toChange.getShapeType());
		if(newShape!=null){// avoid Nullpointer while drawing
		toChange.change(newShape);
		ks.repaint();
		}
		System.out.println("l.103, shape was null");
		// change
		return true;
	}

	// ask the user for the size to create or change a shape
	// depends on shapeType
	private static List<Double> getShapeSize(ShapeType forType) {
//		JPanel myPanel = new JPanel();
		try{
		List<Double> size = null;
		// 1. Erfrage size, abhängig vom Shape Typen
		JTextField x = new JTextField(5);
		JTextField y = new JTextField(5);
		JTextField option1 = new JTextField(5);
		JTextField option2 = new JTextField(5);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("x:"));
		myPanel.add(x);
		myPanel.add(new JLabel("y:"));
		myPanel.add(y);

		switch (forType) {
		case CIRCLE:
			myPanel.add(new JLabel("radius:"));
			myPanel.add(option1);
			break;
		case ELYPSE:
			myPanel.add(new JLabel("vertikaler Radius:"));
			myPanel.add(option1);
			myPanel.add(new JLabel("horizontaler Radius:"));
			myPanel.add(option2);
			break;
		case RECTANGLE:
			myPanel.add(new JLabel("Höhe:"));
			myPanel.add(option1);
			myPanel.add(new JLabel("Breite:"));
			myPanel.add(option2);
			break;
		case SQUARE:
			myPanel.add(new JLabel("Kantenlänge:"));
			myPanel.add(option1);
			break;
		case LINE:
			myPanel.add(new JLabel("x2:"));
			myPanel.add(option1);
			myPanel.add(new JLabel("y2:"));
			myPanel.add(option2);
			break;
		default:
		}

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Forminator_v.1.0", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			// return size()-List
			size = new ArrayList<Double>();
			size.add(Double.parseDouble(x.getText()));
			size.add(Double.parseDouble(y.getText()));
			switch (forType) {
			case CIRCLE:
				size.add(Double.parseDouble(option1.getText()));
				break;
			case ELYPSE:
				size.add(Double.parseDouble(option1.getText()));
				size.add(Double.parseDouble(option2.getText()));
				break;
			case RECTANGLE:
				size.add(Double.parseDouble(option1.getText()));
				size.add(Double.parseDouble(option2.getText()));
				break;
			case SQUARE:
				size.add(Double.parseDouble(option1.getText()));
				break;
			case LINE:
				size.add(Double.parseDouble(option1.getText()));
				size.add(Double.parseDouble(option2.getText()));
				break;
			default:
				// eq Point
			}
		}
		return size;
		}catch(Exception e){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Fehler bei der Eingabe","Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	// add a form to shapeList
	private static boolean addForm() {
		// Ask for Type
		ShapeType[] choices = ShapeType.values();
		ShapeType choosenType = (ShapeType) JOptionPane.showInputDialog(null, "Welche Form möchten Sie hinzufügen?",
				"Forminator_v.1.0", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		if (choosenType == null) {
			return false;
		}
		MyShape newShape=getShape(choosenType);
		if(newShape!=null){ //avoid nullpointer to stop program while drawing
			addShape(newShape);
		}
		return true; // keep running

	}

	// create and return a new shape Object 
	private static MyShape getShape(ShapeType type) {
		// get the shape size / dimension depending on ShapeType
		System.out.println(type);
		List<Double> size = getShapeSize(type);

		if (size != null) {
			switch (type) {
			case CIRCLE:
				return new MyCircle(size.get(0), size.get(1), size.get(2));
			case ELYPSE:
				return new MyElypse(size.get(0), size.get(1), size.get(2), size.get(3));
			case POINT:
				return new MyPoint(size.get(0), size.get(1));

			case RECTANGLE:
				return new MyRectangle(size.get(0), size.get(1), size.get(2), size.get(3));

			case SQUARE:
				return new MySquare(size.get(0), size.get(1), size.get(2));

			case LINE:
				return new MyLine(size.get(0), size.get(1), size.get(2), size.get(3));

			default:
				// should never happen
			}
		}
		System.out.println("size was null");
		// no size no object^^
		return null;
		
	}
}
