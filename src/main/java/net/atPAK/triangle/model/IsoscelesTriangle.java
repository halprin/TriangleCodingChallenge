package net.atPAK.triangle.model;

/**
 * An isosceles triangle.  An isosceles triangle has two sides with the same length with the third being different.
 */
public class IsoscelesTriangle extends Triangle
{
	/**
	 * Constructs an {@code IsoscelesTriangle}.
	 *
	 * This is protected to allow construction via the
	 * {@link net.atPAK.triangle.model.Triangle#create(double, double, double)} factory.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @see net.atPAK.triangle.model.Triangle#create(double, double, double)
	 */
	protected IsoscelesTriangle(final double side1, final double side2, final double side3)
	{
		super(side1, side2, side3);
	}

	/**
	 * Returns the type of the triangle
	 *
	 * @return {@link net.atPAK.triangle.model.TriangleType#ISOSCELES}
	 */
	@Override
	public TriangleType getType()
	{
		return TriangleType.ISOSCELES;
	}
}
