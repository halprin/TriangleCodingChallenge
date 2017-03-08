package net.atPAK.triangle.input;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by halprin on 3/7/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(InputManager.class)
public class InputManagerTest
{
	@Test
	public void testWithValidDoubleInput()
	{
		final String[] goodDoubleInput = {"4.4", "7.3", "9.1"};
		final double[] goodDoubleOutput = {4.4, 7.3, 9.1};

		InputManager objectUnderTest = new InputManager(goodDoubleInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodDoubleOutput);
	}

	@Test
	public void testWithValidIntegerInput()
	{
		final String[] goodIntegerInput = {"6", "12", "14"};
		final double[] goodIntegerOutput = {6.0, 12.0, 14.0};

		InputManager objectUnderTest = new InputManager(goodIntegerInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodIntegerOutput);
	}

	@Test
	public void testWithValidSpaceInput()
	{
		final String[] goodSpaceInput = {"   6 ", "              12", "14       "};
		final double[] goodIntegerOutput = {6.0, 12.0, 14.0};

		InputManager objectUnderTest = new InputManager(goodSpaceInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodIntegerOutput);
	}

	@Test
	public void testWithValidCommaInput() throws Exception
	{
		//mock the Scanner so we can provide new numbers programmatically through the Scanner
		Scanner mockedScanner = PowerMockito.mock(Scanner.class);
		when(mockedScanner.nextLine()).thenReturn("4.4").thenReturn("7.3").thenReturn("9.1");
		whenNew(Scanner.class).withAnyArguments().thenReturn(mockedScanner);

		final String[] goodDoubleInput = {"4,4", "7,3", "9,1"};
		final double[] goodDoubleOutput = {4.4, 7.3, 9.1};

		InputManager objectUnderTest = new InputManager(goodDoubleInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodDoubleOutput);
	}

	@Test
	public void testWithNegativeInput()
	{
		final String[] negativeInput = {"-4.4", "7.3", "9.1", "4.4"};
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(negativeInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	@Test
	public void testWithZeroInput()
	{
		final String[] zeroInput = {"0", "7.3", "9.1", "4.4"};
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(zeroInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	@Test
	public void testWithInvalidInput()
	{
		final String[] invalidInput = {"DogCow", "7.3", "9.1", "4.4"};
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(invalidInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	@Test
	public void testWithTooMuchInput()
	{
		final String[] tooMuchInput = {"7.3", "9.1", "4.4", "26"};
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(tooMuchInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	@Test
	public void testWithTooLittleInput() throws Exception
	{
		//mock the Scanner so we can provide new numbers programmatically through the Scanner
		Scanner mockedScanner = PowerMockito.mock(Scanner.class);
		when(mockedScanner.nextLine()).thenReturn("4.4");
		whenNew(Scanner.class).withAnyArguments().thenReturn(mockedScanner);

		final String[] tooLittleInput = {"7.3", "9.1"};
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(tooLittleInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	@Test
	public void testWithInvalidNull() throws Exception
	{
		//mock the Scanner so we can provide new numbers programmatically through the Scanner
		Scanner mockedScanner = PowerMockito.mock(Scanner.class);
		when(mockedScanner.nextLine()).thenReturn("7.3").thenReturn("9.1").thenReturn("4.4");
		whenNew(Scanner.class).withAnyArguments().thenReturn(mockedScanner);

		final String[] nullInput = null;
		final double[] goodOutput = {7.3, 9.1, 4.4};

		InputManager objectUnderTest = new InputManager(nullInput);

		validateInputManagerSidesAreCorrect(objectUnderTest, goodOutput);
	}

	private void validateInputManagerSidesAreCorrect(final InputManager inputManager, final double[] sides)
	{
		assertThat("Side 1 of the InputManager was incorrect.", inputManager.getSide1(), equalTo(sides[0]));
		assertThat("Side 2 of the InputManager was incorrect.", inputManager.getSide2(), equalTo(sides[1]));
		assertThat("Side 3 of the InputManager was incorrect.", inputManager.getSide3(), equalTo(sides[2]));
	}
}
