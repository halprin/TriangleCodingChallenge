package net.atPAK.triangle.model;

/**
 * Created by halprin on 3/7/17.
 */
public class IsoscelesTriangle extends Triangle
{
	/**
	 * The constructor to create a Triangle.
	 *
	 * This is protected to allow construction of child-classes but not allow others.
	 *
	 * @param side1 The length of the first side of the triangle.
	 * @param side2 The length of the second side of the triangle.
	 * @param side3 The length of the third side of the triangle.
	 */
	protected IsoscelesTriangle(final double side1, final double side2, final double side3)
	{
		super(side1, side2, side3);
	}

	@Override
	public TriangleType getType()
	{
		return TriangleType.ISOSCELES;
	}
}
