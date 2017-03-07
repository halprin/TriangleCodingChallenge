package net.atPAK.triangle.exceptions;

import net.atPAK.triangle.model.Triangle;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by halprin on 3/7/17.
 */
public class InvalidTriangleExceptionTest
{
	private static final double SIDE1 = 4.0;
	private static final double SIDE2 = 6.0;
	private static final double SIDE3 = 11.0;

	@Test
	public void testSides()
	{
		InvalidTriangleException objectUnderTest = new InvalidTriangleException(SIDE1, SIDE2, SIDE3);

		assertThat("Side 1 must be " + SIDE1, objectUnderTest.getSide1(), is(SIDE1));
		assertThat("Side 2 must be " + SIDE2, objectUnderTest.getSide2(), is(SIDE2));
		assertThat("Side 3 must be " + SIDE3, objectUnderTest.getSide3(), is(SIDE3));
	}

	@Test(expected = InvalidTriangleException.class)
	public void testCreatingInvalidTriangle()
	{
		Triangle triangle = Triangle.create(SIDE1, SIDE2, SIDE3);
	}
}
