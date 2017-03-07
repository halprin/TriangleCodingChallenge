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
	private static final double SIDE = 1.5;

	@Test
	public void testCreatingEquilateralTriangle()
	{
		Triangle objectUnderTest = Triangle.create(SIDE, SIDE, SIDE);

		assertThat("The triangle type must not be null.", objectUnderTest.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.EQUILATERAL, objectUnderTest.getType(), is(TriangleType.EQUILATERAL));
	}
}
