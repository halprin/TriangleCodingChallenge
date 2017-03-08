package net.atPAK.triangle;

import net.atPAK.triangle.exceptions.InvalidTriangleException;
import net.atPAK.triangle.model.Triangle;

/**
 * Created by halprin on 3/7/17.
 */
public class TriangleMain
{
	public static void main(String[] args)
	{
		double side1 = 4;
		double side2 = 6;
		double side3 = 11;

		if(args.length == 3)
		{
			side1 = new Double(args[0]);
			side2 = new Double(args[1]);
			side3 = new Double(args[2]);
		}

		String triangleType = "";

		try
		{
			Triangle triangle = Triangle.create(side1, side2, side3);
			triangleType = triangle.getType().toString();
		}
		catch(InvalidTriangleException exception)
		{
			triangleType = "not a triangle";
		}

		System.out.println(triangleType);
	}
}
