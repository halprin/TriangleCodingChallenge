package net.atPAK.triangle.model;

import java.util.Objects;

/**
 * Created by halprin on 3/7/17.
 */
public abstract class Triangle
{
	private double side1;
	private double side2;
	private double side3;

	private Triangle()
	{

	}

	protected Triangle(final double side1, final double side2, final double side3)
	{
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
	}

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

	public double getSide1()
	{
		return side1;
	}

	public double getSide2()
	{
		return side2;
	}

	public double getSide3()
	{
		return side3;
	}

	public void setSide1(final double side1)
	{
		this.side1 = side1;
	}

	public void setSide2(final double side2)
	{
		this.side2 = side2;
	}

	public void setSide3(final double side3)
	{
		this.side3 = side3;
	}

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
}
