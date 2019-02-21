import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3); //area 9
		Shape b = new EquilateralTriangle("test2", 4);//6.9
		Shape c = new Square("test3", 4); //area 16
		Shape d = new Circle("test4", 1.5); //area ~7.1

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes();
		
		Assert.assertEquals("Incorrect order", sorter.shapes.get(0), b);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(1), d);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(2), a);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(3), c);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 3); //area 9
		Shape b = new EquilateralTriangle("test2", 4);//6.9
		Shape c = new Square("test3", 4); //area 16
		Shape d = new Circle("test4", 1.5); //area ~7.1

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapeAreaComparator());
		
		Assert.assertEquals("Incorrect order", sorter.shapes.get(0), b);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(1), d);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(2), a);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(3), c);
		
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 3); //perimeter 12.0
		Shape b = new EquilateralTriangle("test2", 5);//perimeter 15.0 
		Shape c = new Square("test3", 4); //perimeter 16.0 
		Shape d = new Circle("test4", 1.5); //perimeter 9.4

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Assert.assertEquals("Incorrect order", sorter.shapes.get(0), d);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(1), a);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(2), b);
		Assert.assertEquals("Incorrect order", sorter.shapes.get(3), c);
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3); //area 9
		Shape b = new EquilateralTriangle("test2", 4);//6.9
		Shape c = new Square("test3", 4); //area 16
		Shape d = new Circle("test4", 1.5); //area ~7.1

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes();
		
		Assert.assertEquals("Incorrect order", sorter.shapes.get(0).toString(), b.toString());
		Assert.assertEquals("Incorrect order", sorter.shapes.get(1).toString(), d.toString());
		Assert.assertEquals("Incorrect order", sorter.shapes.get(2).toString(), a.toString());
		Assert.assertEquals("Incorrect order", sorter.shapes.get(3).toString(), c.toString());
	}
}
