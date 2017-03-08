package net.atPAK.triangle.model;

import net.atPAK.triangle.exceptions.InvalidTriangleException;

import java.util.Objects;

/**
 * A triangle.  It has three sides and angles that sum to 180&deg;.
 */
public abstract class Triangle
{
	private double side1;
	private double side2;
	private double side3;

	/**
	 * The default constructor for {@code Triangle}.
	 *
	 * This must not be called, hence it being private.  Use {@link #create(double, double, double)}
	 *
	 * @see #create(double, double, double)
	 */
	private Triangle()
	{
		//empty on purpose
	}

	/**
	 * Constructs a {@code Triangle}.
	 *
	 * This is protected to allow construction via the
	 * {@link net.atPAK.triangle.model.Triangle#create(double, double, double)} factory.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @see #create(double, double, double)
	 */
	protected Triangle(final double side1, final double side2, final double side3)
	{
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
	}

	/**
	 * The factory method for creating {@code Triangle}s.
	 *
	 * By specifying the length of the sides, the correct kind of {@code Triangle} will be returned.
	 * Could throw the exception {@link net.atPAK.triangle.exceptions.InvalidTriangleException} if invalid lengths are specified.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @return The appropriate type of {@code Triangle} based on the parameters.
	 * @exception net.atPAK.triangle.exceptions.InvalidTriangleException If invalid lengths are specified.
	 */
	public static Triangle create(final double side1, final double side2, final double side3)
	{
		//validate that this triangle is valid
		validateLengths(side1, side2, side3);

		//create and return correct kind of Triangle
		return createCorrectTriangle(side1, side2, side3);
	}

	/**
	 * The length of the first side of the triangle.
	 *
	 * @return The length of the first side of the triangle.
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
	 * The length of the second side of the triangle.
	 *
	 * @return The length of the second side of the triangle.
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
	 * The length of the third side of the triangle.
	 *
	 * @return The length of the third side of the triangle.
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
	 * Returns the type of the triangle
	 *
	 * @return Depends on the length of the sides passed to {@link #create(double, double, double)}.
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

	/**
	 * Returns a {@link java.lang.String} representation of the {@code Triangle}.
	 *
	 * Includes the type and all three sides.
	 *
	 * @return A string representation.
	 */
	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("Triangle{");
		sb.append("type=").append(getType());
		sb.append("side1=").append(side1);
		sb.append(", side2=").append(side2);
		sb.append(", side3=").append(side3);
		sb.append('}');
		return sb.toString();
	}

	private static void validateLengths(final double side1, final double side2, final double side3)
	{
		//Triangle Inequality Theorem
		if(!(side1 + side2 > side3))
		{
			throw new InvalidTriangleException(side1, side2, side3);
		}

		if(!(side1 + side3 > side2))
		{
			throw new InvalidTriangleException(side1, side2, side3);
		}

		if(!(side2 + side3 > side1))
		{
			throw new InvalidTriangleException(side1, side2, side3);
		}
	}

	private static Triangle createCorrectTriangle(final double side1, final double side2, final double side3)
	{
		Triangle triangle = null;

		if(isEquilateral(side1, side2, side3))
		{
			//the triangle is equilateral
			triangle = new EquilateralTriangle(side1, side2, side3);
		}
		else if(isIsosceles(side1, side2, side3))
		{
			//the triangle is isosceles
			triangle = new IsoscelesTriangle(side1, side2, side3);
		}
		else if(isScalene(side1, side2, side3))
		{
			//the triangle is scalene
			triangle = new ScaleneTriangle(side1, side2, side3);
		}
		else
		{
			//another test for an invalid triangle
			throw new InvalidTriangleException(side1, side2, side3);
		}

		return triangle;
	}

	private static boolean isEquilateral(final double side1, final double side2, final double side3)
	{
		return (side1 == side2 && side2 == side3);
	}

	private static boolean isIsosceles(final double side1, final double side2, final double side3)
	{
		boolean test1 = (side1 == side2 && side1 != side3);
		boolean test2 = (side1 == side3 && side1 != side2);
		boolean test3 = (side2 == side3 && side2 != side1);

		return test1 || test2 || test3;
	}

	private static boolean isScalene(final double side1, final double side2, final double side3)
	{
		return (side1 != side2 && side1 != side3 && side2 != side3);
	}
}
