package net.atPAK.triangle.model;

/**
 * The different types of triangles.
 * <ul>
 * <li>Equilateral - has the same length for all three sides.</li>
 * <li>Isosceles - has two sides with the same length with the third being different.</li>
 * <li>Scalene - has different lengths for all three sides.</li>
 * </ul>
 */
public enum TriangleType
{
	/**
	 * Has the same length for all three sides.
	 */
	EQUILATERAL("equilateral"),

	/**
	 * Has two sides with the same length with the third being different.
	 */
	ISOSCELES("isosceles"),

	/**
	 * Has different lengths for all three sides.
	 */
	SCALENE("scalene");

	private String type;

	TriangleType(final String type)
	{
		setType(type);
	}

	private String getType()
	{
		return type;
	}

	private void setType(final String type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return getType();
	}
}
