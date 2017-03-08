package net.atPAK.triangle.input;

import org.junit.Test;

/**
 * Created by halprin on 3/7/17.
 */
public class InputManagerTest
{
	private InputManager objectUnderTest;

	@Test
	public void testWithValidDoubleInput()
	{
		final String[] goodDoubleInput = {"4.4", "7.3", "9.1"};
		final double[] goodDoubleOutput = {4.4, 7.3, 9.1};
	}

	@Test
	public void testWithValidIntegerInput()
	{
		final String[] goodIntegerInput = {"6", "12", "14"};
		final double[] goodIntegerOutput = {6.0, 12.0, 14.0};
	}

	@Test
	public void testWithNegativeInput()
	{
		final String[] negativeInput = {"-4.4", "7.3", "9.1", "4.4"};
		final double[] goodOutput = {7.3, 9.1, 4.4};
	}

	@Test
	public void testWithInvalidInput()
	{
		final String[] invalidInput = {"DogCow", "7.3", "9.1", "4.4"};
		final double[] goodOutput = {7.3, 9.1, 4.4};
	}

	@Test
	public void testWithTooMuchInput()
	{
		final String[] tooMuchInput = {"7.3", "9.1", "4.4", "26"};
		final double[] goodOutput = {7.3, 9.1, 4.4};
	}

	@Test
	public void testWithTooLittleInput()
	{
		//final String[] tooLittleInput = {"7.3", "9.1"};
		//final double[] goodOutput = {7.3, 9.1};
	}
}
