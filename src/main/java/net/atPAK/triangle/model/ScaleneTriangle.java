package net.atPAK.triangle.model;

/**
 * A scalene triangle.  A scalene triangle has different lengths for all three sides.
 */
public class ScaleneTriangle extends Triangle
{
	/**
	 * Constructs a {@code ScaleneTriangle}.
	 *
	 * This is protected to allow construction via the
	 * {@link net.atPAK.triangle.model.Triangle#create(double, double, double)} factory.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 * @see net.atPAK.triangle.model.Triangle#create(double, double, double)
	 */
	protected ScaleneTriangle(final double side1, final double side2, final double side3)
	{
		super(side1, side2, side3);
	}

	/**
	 * Returns the type of the triangle
	 *
	 * @return {@link net.atPAK.triangle.model.TriangleType#SCALENE}
	 */
	@Override
	public TriangleType getType()
	{
		return TriangleType.SCALENE;
	}
}
