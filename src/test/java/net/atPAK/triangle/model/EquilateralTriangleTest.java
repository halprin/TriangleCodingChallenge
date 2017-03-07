package net.atPAK.triangle.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by halprin on 3/7/17.
 */
public class EquilateralTriangleTest
{
	@Test
	public void testCreatingEquilateralTriangle()
	{
		final double side = 1.5;
		Triangle objectUnderTest = Triangle.create(side, side, side);

		assertEquilateralTriangleType(objectUnderTest);
	}

	@Test
	public void testOtherSizeEquilateralTriangle()
	{
		final double side = 26;
		Triangle objectUnderTest = Triangle.create(side, side, side);

		assertEquilateralTriangleType(objectUnderTest);
	}

	private void assertEquilateralTriangleType(Triangle triangle)
	{
		assertThat("The triangle type must not be null.", triangle.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.EQUILATERAL, triangle.getType(), is(TriangleType.EQUILATERAL));
	}
}
