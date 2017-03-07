package net.atPAK.triangle.model;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

/**
 * Created by halprin on 3/7/17.
 */
public class TriangleTypeTest
{
	private TriangleType objectUnderTest;

	@Test
	public void testEnumCount()
	{
		assertThat("The enumeration should have three values.", objectUnderTest.values().length, is(3));
	}

	@Test
	public void testSpecificEnumValues()
	{
		TriangleType[] onlyValidValues = { TriangleType.EQUILATERAL, TriangleType.ISOSCELES, TriangleType.SCALENE };
		assertThat("The enumeration must have only EQUILATERAL, ISOSCELES, or SCALENE!", Arrays.asList(objectUnderTest.values()), containsInAnyOrder(onlyValidValues));
	}
}
