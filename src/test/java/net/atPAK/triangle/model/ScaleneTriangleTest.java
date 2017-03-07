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
	private static final double SIDE1 = 4.0;
	private static final double SIDE2 = 6.0;
	private static final double SIDE3 = 11.0;

	@Test
	public void testCreatingScaleneTriangle()
	{
		Triangle objectUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);

		assertThat("The triangle type must not be null.", objectUnderTest.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.SCALENE, objectUnderTest.getType(), is(TriangleType.SCALENE));
	}
}
