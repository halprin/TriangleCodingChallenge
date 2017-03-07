package net.atPAK.triangle.exceptions;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Created by halprin on 3/7/17.
 */
public class InvalidTriangleException extends RuntimeException
{
	private static final String MESSAGE = "Invalid triangle with sides = {0}, {1}, {2}";

	private double side1;
	private double side2;
	private double side3;

	public InvalidTriangleException(final double side1, final double side2, final double side3)
	{
		super(MessageFormat.format(MESSAGE, side1, side2, side3));
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
	}

	/**
	 * @return double The invalid length of the first side of the "triangle".
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
	 * @return double The invalid length of the second side of the "triangle".
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
	 * @return double The invalid length of the third side of the "triangle".
	 */
	public double getSide3()
	{
		return side3;
	}

	private void setSide3(final double side3)
	{
		this.side3 = side3;
	}

	@Override
	public boolean equals(final Object o)
	{
		if(this == o)
		{
			return true;
		}
		if(!(o instanceof InvalidTriangleException))
		{
			return false;
		}
		final InvalidTriangleException that = (InvalidTriangleException)o;
		return Double.compare(that.getSide1(), getSide1()) == 0 &&
					   Double.compare(that.getSide2(), getSide2()) == 0 &&
					   Double.compare(that.getSide3(), getSide3()) == 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getSide1(), getSide2(), getSide3());
	}
}
