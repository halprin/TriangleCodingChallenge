package net.atPAK.triangle.model;

import org.junit.Ignore;
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
	private static final double MINIMUM_DOUBLE_DELTA = 0.000000000000001;

	@Test
	public void testCreateAnyTriangle()
	{
		Triangle objectUnderTest = Triangle.create(4.0, 6.0, 11.0);

		assertThat("Side 1 must be 4.0.", objectUnderTest.getSide1(), is(4.0));
		assertThat("Side 2 must be 6.0.", objectUnderTest.getSide2(), is(6.0));
		assertThat("Side 3 must be 11.0.", objectUnderTest.getSide3(), is(11.0));
	}

	@Test
	public void testTrianglesEqual()
	{
		Triangle objectUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherSameTriangleUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherDifferentTriangle = Triangle.create(4 + MINIMUM_DOUBLE_DELTA, 6.0, 11.0);

		assertThat("The triangles must equal each other.", objectUnderTest, equalTo(otherSameTriangleUnderTest));
		assertThat("The triangles must NOT equal each other.", objectUnderTest, not(equalTo(otherDifferentTriangle)));
	}

	@Test
	public void testTrianglesHash()
	{
		Triangle objectUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherSameTriangleUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherDifferentTriangle = Triangle.create(4 + MINIMUM_DOUBLE_DELTA, 6.0, 11.0);

		assertThat("The triangles must hash to the same value.", objectUnderTest.hashCode(), equalTo(otherSameTriangleUnderTest.hashCode()));
		assertThat("The triangles must NOT hash to the same value.", objectUnderTest.hashCode(), not(equalTo(otherDifferentTriangle.hashCode())));
	}

	@Test
	@Ignore
	public void testCreatingInvalidTriangle()
	{

	}
}
