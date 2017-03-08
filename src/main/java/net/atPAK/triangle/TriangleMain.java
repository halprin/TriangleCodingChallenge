package net.atPAK.triangle;

import net.atPAK.triangle.exceptions.InvalidTriangleException;
import net.atPAK.triangle.input.InputManager;
import net.atPAK.triangle.model.Triangle;

/**
 * The main executor class.
 */
public class TriangleMain
{
	public static void main(String[] args)
	{
		//use the InputManager to parse the input
		final InputManager inputManager = new InputManager(args);

		String triangleType = "";

		try
		{
			//create the triangle!
			final Triangle triangle = Triangle.create(inputManager.getSide1(), inputManager.getSide2(), inputManager.getSide3());
			triangleType = triangle.getType().toString();
		}
		catch(InvalidTriangleException exception)
		{
			triangleType = "not a triangle";
		}

		System.out.println(triangleType);
	}
}
