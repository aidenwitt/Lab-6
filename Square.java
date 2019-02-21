/**
 * Lab 6
 *
 * Class representing a rectangle.
 *
 * @author Aiden Witt
 * @version 2019-02-21
 */
public class Square extends Rectangle {
	
	public Square(String id, double size) {
		super(id, size, size);
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Rectangle"
	 */
	public String getShapeType() {
		return "Square";
	}
}
