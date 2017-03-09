package net.atPAK.triangle.exceptions;

import net.atPAK.triangle.model.Triangle;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by halprin on 3/7/17.
 */
public class InvalidTriangleExceptionTest
{
	private static final double SIDE1 = 4.0;
	private static final double SIDE2 = 6.0;
	private static final double SIDE3 = 11.0;
	private static final double MINIMUM_DOUBLE_DELTA = 0.000000000000001;

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

	@Test(expected = InvalidTriangleException.class)
	public void testCreatingInvalidTriangleWithDifferentSides()
	{
		Triangle triangle = Triangle.create(SIDE3, SIDE1, SIDE2);
	}

	@Test(expected = InvalidTriangleException.class)
	public void testCreatingInvalidTriangleWithDifferentSidesAgain()
	{
		Triangle triangle = Triangle.create(SIDE2, SIDE3, SIDE1);
	}

	@Test
	public void testExceptionEqual()
	{
		InvalidTriangleException objectUnderTest = new InvalidTriangleException(SIDE1, SIDE2, SIDE3);
		InvalidTriangleException otherSameExceptionUnderTest = new InvalidTriangleException(SIDE1, SIDE2, SIDE3);
		InvalidTriangleException otherDifferentException = new InvalidTriangleException(SIDE1 + MINIMUM_DOUBLE_DELTA, SIDE2, SIDE3);

		assertThat("The exception must equal itself.", objectUnderTest, equalTo(objectUnderTest));
		assertThat("The exceptions must equal each other.", objectUnderTest, equalTo(otherSameExceptionUnderTest));
		assertThat("The exceptions must NOT equal each other.", objectUnderTest, not(equalTo(otherDifferentException)));
		assertThat("The exception must NOT equal a different object.", objectUnderTest, not(equalTo(new Object())));
	}

	@Test
	public void testExceptionHash()
	{
		InvalidTriangleException objectUnderTest = new InvalidTriangleException(SIDE1, SIDE2, SIDE3);
		InvalidTriangleException otherSameExceptionUnderTest = new InvalidTriangleException(SIDE1, SIDE2, SIDE3);
		InvalidTriangleException otherDifferentException = new InvalidTriangleException(SIDE1 + MINIMUM_DOUBLE_DELTA, SIDE2, SIDE3);

		assertThat("The exceptions must hash to the same value.", objectUnderTest.hashCode(), equalTo(otherSameExceptionUnderTest.hashCode()));
		assertThat("The exceptions must NOT hash to the same value.", objectUnderTest.hashCode(), not(equalTo(otherDifferentException.hashCode())));
	}
}
