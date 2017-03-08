package net.atPAK.triangle.model;

/**
 * An equilateral triangle.  An equilateral triangle has the same length for all three sides.
 */
public class EquilateralTriangle extends Triangle
{
	/**
	 * Constructs an {@code EquilateralTriangle}.
	 *
	 * This is protected to allow construction via the
	 * {@link net.atPAK.triangle.model.Triangle#create(double, double, double)} factory.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @see net.atPAK.triangle.model.Triangle#create(double, double, double)
	 */
	protected EquilateralTriangle(final double side1, final double side2, final double side3)
	{
		super(side1, side2, side3);
	}

	/**
	 * Returns the type of the triangle
	 *
	 * @return {@link net.atPAK.triangle.model.TriangleType#EQUILATERAL}
	 */
	@Override
	public TriangleType getType()
	{
		return TriangleType.EQUILATERAL;
	}
}
