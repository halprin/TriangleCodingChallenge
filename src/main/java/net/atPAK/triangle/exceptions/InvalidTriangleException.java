package net.atPAK.triangle.exceptions;

/**
 * Created by halprin on 3/7/17.
 */
public class InvalidTriangleException extends RuntimeException
{
	private double side1;
	private double side2;
	private double side3;

	public InvalidTriangleException(final double side1, final double side2, final double side3)
	{
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
}
