package net.atPAK.triangle.input;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Helps in obtaining lengths of sides.  The {@code InputManager} does this in two ways.
 * <ol>
 * <li>Parses command line arguments (or an array of {@link java.lang.String Strings}) looking for {@code double}
 * representations.</li>
 * <li>Prompts the user via {@code STDOUT} and {@code STDIN} to supply additional doubles for the remaining sides.</li>
 * </ol>
 * <br>
 * When parsing the doubles from the the array or from {@code STDIN}, {@link java.lang.Double#valueOf(String)} is
 * utilized.
 * The following input is invalid in addition to what is considered invalid by {@link java.lang.Double#valueOf(String)}.
 * <ul>
 * <li>Negative numbers</li>
 * <li>Zero ({@code 0})</li>
 * </ul>
 * When invalid input is encountered, the input is thrown out and the next {@link java.lang.String String}) in the array
 * is parsed or the user is prompted again.
 */
public class InputManager
{
	private static final String PROMPT = "Please supply a number for side {0}: ";
	private double side1 = 0;
	private double side2 = 0;
	private double side3 = 0;

	/**
	 * Constructs an {@code InputManager}.
	 *
	 * @param arguments The array of {@link java.lang.String Strings} to parse into doubles.
	 */
	public InputManager(String[] arguments)
	{
		parseArguments(arguments);

		promptForExtraRequiredInput();
	}

	/**
	 * The first {@code double} that was parsed.
	 *
	 * @return The first {@code double} that was parsed.
	 */
	public double getSide1()
	{
		return side1;
	}

	private void setSide1(final double side1)
	{
		this.side1 = side1;
	}

	/**
	 * The second {@code double} that was parsed.
	 *
	 * @return The second {@code double} that was parsed.
	 */
	public double getSide2()
	{
		return side2;
	}

	private void setSide2(final double side2)
	{
		this.side2 = side2;
	}

	/**
	 * The third {@code double} that was parsed.
	 *
	 * @return The third {@code double} that was parsed.
	 */
	public double getSide3()
	{
		return side3;
	}

	private void setSide3(final double side3)
	{
		this.side3 = side3;
	}

	private void parseArguments(final String[] arguments)
	{
		if(arguments == null)
		{
			//no arguments exist, skip parsing
			return;
		}

		//iterate over all the arguments
		for(String argument : arguments)
		{
			//try to convert and set one of the sides based on the argument
			convertAndSetNextSide(argument);

			//check if we need to continue trying to convert arguments
			if(allSidesSet())
			{
				break;
			}
		}
	}

	private void promptForExtraRequiredInput()
	{
		while(!allSidesSet())
		{
			promptForNextSide();
		}
	}

	private void promptForNextSide()
	{
		System.out.print(MessageFormat.format(PROMPT, nextSideNumber()));

		Scanner sideReader = new Scanner(System.in);
		String nextInput = sideReader.nextLine();

		convertAndSetNextSide(nextInput);
	}

	private String nextSideNumber()
	{
		if(getSide1() == 0)
		{
			//side1 needs to be set next
			return "1";
		}
		else if(getSide2() == 0)
		{
			//side2 needs to be set next
			return "2";
		}
		else if(getSide3() == 0)
		{
			//side3 needs to be set next
			return "3";
		}

		return "";
	}

	private boolean allSidesSet()
	{
		return (getSide1() != 0) && (getSide2() != 0) && (getSide3() != 0);
	}

	private void convertAndSetNextSide(final String argument)
	{
		double doubleValue = 0;

		try
		{
			doubleValue = Double.valueOf(argument);
		}
		catch(NumberFormatException exception)
		{
			//invalid arguments need not apply
			return;
		}

		if(doubleValue <= 0)
		{
			//zero and negative numbers need not apply
			return;
		}

		setNextSide(doubleValue);
	}

	private void setNextSide(final double doubleValue)
	{
		if(getSide1() == 0)
		{
			//side1 needs to be set next
			setSide1(doubleValue);
		}
		else if(getSide2() == 0)
		{
			//side2 needs to be set next
			setSide2(doubleValue);
		}
		else if(getSide3() == 0)
		{
			//side3 needs to be set next
			setSide3(doubleValue);
		}
	}
}
