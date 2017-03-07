package net.atPAK.triangle.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * Created by halprin on 3/7/17.
 */
public abstract class Triangle
{
	private double side1;
	private double side2;
	private double side3;

	/**
	 * The default constructor for Triangle.
	 *
	 * This must not be called, hence it being private.
	 */
	private Triangle()
	{

	}

	/**
	 * The constructor for how triangles are created for now.
	 *
	 * @param side1
	 * @param side2
	 * @param side3
	 */
	protected Triangle(final double side1, final double side2, final double side3)
	{
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
	}

	/**
	 * The factory method for creating Triangles.
	 *
	 * The factory method for creating a Triangle.  By specifying the sizes of the sides, the correct kind of Triangle will be returned.
	 * Could throw the exception InvalidTriangleException if invalid lengths are specified.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @return Triangle The triangle given the arguments.
	 */
	public static Triangle create(final double side1, final double side2, final double side3)
	{
		//TODO: create a dumb triangle for now
		return new Triangle(side1, side2, side3)
		{
			@Override
			public TriangleType getType()
			{
				return null;
			}
		};
	}

	/**
	 * @return double The length of the first side of the triangle.
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
	 * @return double The length of the second side of the triangle.
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
	 * @return double The length of the third side of the triangle.
	 */
	public double getSide3()
	{
		return side3;
	}

	private void setSide3(final double side3)
	{
		this.side3 = side3;
	}

	/**
	 * @return TriangleType The type of the triangle.
	 */
	public abstract TriangleType getType();

	@Override
	public boolean equals(final Object o)
	{
		if(this == o)
		{
			return true;
		}
		if(!(o instanceof Triangle))
		{
			return false;
		}
		final Triangle triangle = (Triangle)o;
		return Double.compare(triangle.side1, side1) == 0 &&
					   Double.compare(triangle.side2, side2) == 0 &&
					   Double.compare(triangle.side3, side3) == 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(side1, side2, side3);
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this)
					   .append("type", getType())
					   .append("side1", side1)
					   .append("side2", side2)
					   .append("side3", side3)
					   .toString();
	}
}
