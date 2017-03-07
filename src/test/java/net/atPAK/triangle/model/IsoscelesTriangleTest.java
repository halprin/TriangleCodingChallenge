package net.atPAK.triangle.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by halprin on 3/7/17.
 */
public class IsoscelesTriangleTest
{
	@Test
	public void testCreatingIsoscelesTriangle()
	{
		final double side1 = 3.0;
		final double side2 = 4.0;
		Triangle objectUnderTest = Triangle.create(side1, side2, side2);

		assertIsoscelesTriangleType(objectUnderTest);
	}

	@Test
	public void testOtherSizeIsoscelesTriangle()
	{
		final double side1 = 12.0;
		final double side2 = 8.0;
		Triangle objectUnderTest = Triangle.create(side1, side2, side2);

		assertIsoscelesTriangleType(objectUnderTest);
	}

	private void assertIsoscelesTriangleType(Triangle triangle)
	{
		assertThat("The triangle type must not be null.", triangle.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.ISOSCELES, triangle.getType(), is(TriangleType.ISOSCELES));
	}
}
