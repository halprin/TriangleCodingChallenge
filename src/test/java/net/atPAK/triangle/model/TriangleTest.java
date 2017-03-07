package net.atPAK.triangle.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by halprin on 3/7/17.
 */
public class TriangleTest
{
	private static final double SIDE1 = 4.4;
	private static final double SIDE2 = 7.3;
	private static final double SIDE3 = 9.1;
	private static final double MINIMUM_DOUBLE_DELTA = 0.000000000000001;

	@Test
	public void testCreateAnyTriangle()
	{
		Triangle objectUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);

		assertThat("Side 1 must be " + SIDE1, objectUnderTest.getSide1(), is(SIDE1));
		assertThat("Side 2 must be " + SIDE2, objectUnderTest.getSide2(), is(SIDE2));
		assertThat("Side 3 must be " + SIDE3, objectUnderTest.getSide3(), is(SIDE3));
	}

	@Test
	public void testTrianglesEqual()
	{
		Triangle objectUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);
		Triangle otherSameTriangleUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);
		Triangle otherDifferentTriangle = Triangle.create(SIDE1 + MINIMUM_DOUBLE_DELTA, SIDE2, SIDE3);

		assertThat("The triangles must equal each other.", objectUnderTest, equalTo(otherSameTriangleUnderTest));
		assertThat("The triangles must NOT equal each other.", objectUnderTest, not(equalTo(otherDifferentTriangle)));
	}

	@Test
	public void testTrianglesHash()
	{
		Triangle objectUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);
		Triangle otherSameTriangleUnderTest = Triangle.create(SIDE1, SIDE2, SIDE3);
		Triangle otherDifferentTriangle = Triangle.create(SIDE1 + MINIMUM_DOUBLE_DELTA, SIDE2, SIDE3);

		assertThat("The triangles must hash to the same value.", objectUnderTest.hashCode(), equalTo(otherSameTriangleUnderTest.hashCode()));
		assertThat("The triangles must NOT hash to the same value.", objectUnderTest.hashCode(), not(equalTo(otherDifferentTriangle.hashCode())));
	}
}
