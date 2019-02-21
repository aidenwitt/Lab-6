import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
		System.out.println(sqr.getPerimeter());
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rct = new Rectangle("Rectangle1", 3.0, 6.0);
		Assert.assertEquals("Rectangle area incorrect.", 18.0, rct.getArea(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rct.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rct.getId());
		Assert.assertEquals("Rectangle perimeter incorrect.", 18.0, rct.getPerimeter(), 0.0001);
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape tri = new EquilateralTriangle("EquilateralTriangle1", 5.0);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "EquilateralTriangle1", tri.getId());
		Assert.assertEquals("Triangle area incorrect.", 10.825317, tri.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 15.0, tri.getPerimeter(), 0.0001);
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trp = new Trapezoid("Trapezoid1", 13.0, 13.0, 16.0, 26.0);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trp.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trp.getId());
		Assert.assertEquals("Trapezoid area incorrect.", 252, trp.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 68.0, trp.getPerimeter(), 0.0001);
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape crc = new Circle("Circle1", 5.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*5.0*5.0, crc.getArea(),0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 5.0, crc.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle",crc.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", crc.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Shape rct = new Rectangle("Rectangle1", 3.0, 6.0);
		Shape tri = new EquilateralTriangle("EquilateralTriangle1", 5.0);
		Shape trp = new Trapezoid("Trapezoid1", 13.0, 13.0, 16.0, 26.0);
		Shape eps = new Ellipse("Ellipse1", 3.0, 3.0);
		Shape crc = new Circle("Circle1", 5.0);
		
		System.out.println(sqr.toString());
		System.out.println(rct.toString());
		System.out.println(tri.toString());
		System.out.println(trp.toString());
		System.out.println(eps.toString());
		System.out.println(crc.toString());
		
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// Test equals:
		Shape rct = new Rectangle("R1", 3.0, 3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapePerimeterComparator spc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, spc.compare(rct, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", spc.equals(rct, sqr));
		
		// Test equal area, different perimeter:
        Shape rct2 = new Rectangle("R2", 2.0, 18.0);
        Shape sqr2 = new Square("S2", 6.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, spc.compare(rct2, sqr2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, spc.compare(sqr2, rct2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", spc.equals(rct2, sqr2));

        // Test unequal perimeter and area:
        Shape rct3 = new Rectangle("R2", 5.0, 10.0);
        Shape sqr3 = new Square("S2", 6.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, spc.compare(sqr3, rct3));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, spc.compare(rct3, sqr3));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", spc.equals(sqr3, rct3));

	}
	
	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// First term smaller than second
		Shape rct1 = new Rectangle("R1", 3.0, 3.0);
		Shape crc1 = new Circle("C1", 3.0);
		Assert.assertEquals("compareTo method should find shapes unequal.", -1, rct1.compareTo(crc1));
		
		// First term larger than second
		Shape rct2 = new Rectangle("R2", 3.0, 3.0);
		Shape tri2 = new EquilateralTriangle("T2", 3.0);
		Assert.assertEquals("compareTo method should find shapes unequal.", 1, rct2.compareTo(tri2));
		
		// Area same, perimeter of first term smaller than second
		Shape sqr3 = new Square("S3", 3.0);
		Shape rct3 = new Rectangle("R3", 4.5, 2.0);
		Assert.assertEquals("compareTo method should find shapes unequal.", -1, sqr3.compareTo(rct3));
				
		// Area same, perimeter of first term smaller than second
		Shape sqr4 = new Square("S4", 3.0);
		Shape rct4 = new Rectangle("R4", 4.5, 2.0);
		Assert.assertEquals("compareTo method should find shapes unequal.", 1, rct4.compareTo(sqr4));
				
		// Test equals:
		Shape rct5 = new Rectangle("R5", 3.0, 3.0);
		Shape sqr5 = new Square("S5", 3.0);
		Assert.assertEquals("compareTo method should find shapes equal.", 0, rct5.compareTo(sqr5));
		
		
	}
}
