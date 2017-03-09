package net.atPAK.triangle;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by halprin on 3/8/17.
 */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(TriangleMain.class)
public class TriangleMainTest
{
	private static String LF = "\n";
	private static String EQUILATERAL = "equilateral" + LF;
	private static String ISOSCELES = "isosceles" + LF;
	private static String SCALENE = "scalene" + LF;
	private static String NOT_A_TRIANGLE = "not a triangle" + LF;

	private static ByteArrayOutputStream outputStream;

	private static PrintStream stdOut;

	@BeforeClass
	public static void setup2()
	{
		//save the actual STDOUT
		stdOut = System.out;
	}

	@AfterClass
	public static void tearDown()
	{
		//re-instantiate the actual STDOUT
		System.setOut(stdOut);
	}

	@Before
	public void setUp()
	{
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void testEquilateralIntegration() throws IOException
	{
		//test
		final String[] equilateralInput = {"1.5", "1.5", "1.5"};
		TriangleMain.main(equilateralInput);
		outputStream.flush();

		//assert
		String written = new String(outputStream.toByteArray());
		assertThat("The triangle must be " + EQUILATERAL, written, is(EQUILATERAL));
	}

	@Test
	public void testIsoscelesIntegration() throws IOException
	{
		//test
		final String[] equilateralInput = {"3", "4", "4"};
		TriangleMain.main(equilateralInput);
		outputStream.flush();

		//assert
		String written = new String(outputStream.toByteArray());
		assertThat("The triangle must be " + ISOSCELES, written, is(ISOSCELES));
	}

	@Test
	public void testScaleneIntegration() throws IOException
	{
		//test
		final String[] equilateralInput = {"4.4", "7.3", "9.1"};
		TriangleMain.main(equilateralInput);
		outputStream.flush();

		//assert
		String written = new String(outputStream.toByteArray());
		assertThat("The triangle must be " + SCALENE, written, is(SCALENE));
	}

	@Test
	public void testNotATriangleIntegration() throws IOException
	{
		//test
		final String[] equilateralInput = {"4", "6", "11"};
		TriangleMain.main(equilateralInput);
		outputStream.flush();

		//assert
		String written = new String(outputStream.toByteArray());
		assertThat("The triangle must be " + NOT_A_TRIANGLE, written, is(NOT_A_TRIANGLE));
	}
}