/**
 * Lab 6
 *
 * Class representing a rectangle.
 *
 * @author Aiden Witt
 * @version 2019-02-21
 */
public class Rectangle extends Polygon {
	/**
     * Length of the sides of the rectangle.
     */
	private double width, height;
	
	/**
	 * Constructor for the rectangle. Sets sideLength member variable and sets
	 * all side length in Polygon sidelengths array.
	 *
	 * @param sidelength The length of the rectangles sides.
	 */
	public Rectangle(String id, double width, double height) {
		super(id);
		this.width = width;
		this.height = height;
		sideLengths.add(this.width); sideLengths.add(this.width);
		sideLengths.add(this.height); sideLengths.add(this.height);	
	}
	
	/**
	 * Gets the area of the rectangle;
	 *
	 * @return The area of the triangle (width * height)
	 */
	@Override
	public double getArea() {
		return width * height;
	}
	
	/**
	 * Gets the type of the shape.
	 *
	 * @return The string "Rectangle"
	 */
	public String getShapeType() {
		return "Rectangle";
	}
	
}
