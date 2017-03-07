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
	public static final double SIDE1 = 3.0;
	public static final double SIDE2 = 4.0;

	@Test
	public void testCreatingIsoscelesTriangle()
	{
		Triangle objectUnderTest = Triangle.create(SIDE1, SIDE2, SIDE2);

		assertThat("The triangle type must not be null.", objectUnderTest.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.ISOSCELES, objectUnderTest.getType(), is(TriangleType.ISOSCELES));
	}
}
