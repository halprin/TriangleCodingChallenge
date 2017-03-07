package net.atPAK.triangle.model;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by halprin on 3/7/17.
 */
public class TriangleTest
{
	private Triangle objectUnderTest;

	private static final double MINIMUM_DOUBLE_DELTA = 0.000000000000001;

	@Test
	public void testCreateAnyTriangle()
	{
		objectUnderTest = Triangle.create(4.0, 6.0, 11.0);

		assertThat("Side 1 must be 4.0.", objectUnderTest.getSide1(), is(4.0));
		assertThat("Side 1 must be 6.0.", objectUnderTest.getSide2(), is(6.0));
		assertThat("Side 1 must be 11.0.", objectUnderTest.getSide3(), is(11.0));
	}

	@Test
	public void testTrianglesEqual()
	{
		objectUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherSameTriangleUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherDifferentTriangle = Triangle.create(4 + MINIMUM_DOUBLE_DELTA, 6.0, 11.0);

		assertThat("The triangles must equal each other.", objectUnderTest, equalTo(otherSameTriangleUnderTest));
		assertThat("The triangles must NOT equal each other.", objectUnderTest, not(equalTo(otherDifferentTriangle)));
	}

	@Test
	public void testTrianglesHash()
	{
		objectUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherSameTriangleUnderTest = Triangle.create(4.0, 6.0, 11.0);
		Triangle otherDifferentTriangle = Triangle.create(4 + MINIMUM_DOUBLE_DELTA, 6.0, 11.0);

		assertThat("The triangles must hash to the same value.", objectUnderTest.hashCode(), equalTo(otherSameTriangleUnderTest.hashCode()));
		assertThat("The triangles must NOT hash to the same value.", objectUnderTest.hashCode(), not(equalTo(otherDifferentTriangle.hashCode())));
	}

	@Test
	@Ignore
	public void testCreatingIsoscelesTriangle()
	{
		objectUnderTest = Triangle.create(3, 4, 4);

		assertThat("The triangle type must not be null.", objectUnderTest.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.ISOSCELES, objectUnderTest.getType(), is(TriangleType.ISOSCELES));
	}

	@Test
	@Ignore
	public void testCreatingScaleneTriangle()
	{
		objectUnderTest = Triangle.create(4, 6, 11);

		assertThat("The triangle type must not be null.", objectUnderTest.getType(), is(notNullValue()));
		assertThat("The triangle type must be " + TriangleType.SCALENE, objectUnderTest.getType(), is(TriangleType.SCALENE));
	}

	@Test
	public void testCreatingInvalidTriangle()
	{

	}
}
