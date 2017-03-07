package net.atPAK.triangle.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by halprin on 3/7/17.
 */
public class ScaleneTriangleTest
{
	@Test
	public void testCreatingScaleneTriangle()
	{
		final double side1 = 4.0;
		final double side2 = 6.0;
		final double side3 = 11.0;
		Triangle objectUnderTest = Triangle.create(side1, side2, side3);

		assertScaleneTriangleType(objectUnderTest);
	}

	@Test
	public void testOtherSizeScaleneTriangle()
	{
		final double side1 = 6.0;
		final double side2 = 45.0;
		final double side3 = 14.0;
		Triangle objectUnderTest = Triangle.create(side1, side2, side3);

		assertScaleneTriangleType(objectUnderTest);
	}

	private void assertScaleneTriangleType(Triangle triangle)
	{
		assertThat("The triangle type must not be null.", triangle.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.SCALENE, triangle.getType(), is(TriangleType.SCALENE));
	}
}
