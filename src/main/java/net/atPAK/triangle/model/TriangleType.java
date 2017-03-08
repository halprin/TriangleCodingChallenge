package net.atPAK.triangle.model;

/**
 * Created by halprin on 3/7/17.
 */
public enum TriangleType
{
	EQUILATERAL("equilateral"),
	ISOSCELES("isosceles"),
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
