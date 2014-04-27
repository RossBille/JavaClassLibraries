package com.rossbille.common.eithers;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rossbille
 */
public class HelpersTest{

	public HelpersTest(){
	}

	@BeforeClass
	public static void setUpClass(){
	}

	@AfterClass
	public static void tearDownClass(){
	}

	@Before
	public void setUp(){
	}

	@After
	public void tearDown(){
	}

	/**
	 * Test of partitionEithers method, of class Helpers.
	 */
	@Test
	public void testPartitionEithers(){
		System.out.println("partitionEithers");

		//set up expected values
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		String f = "f";

		//set up individual eithers
		Either<Object, String> ae = Either.right(a);
		Either<Object, String> be = Either.right(b);
		Either<Object, String> ce = Either.right(c);
		Either<Object, String> de = Either.right(d);
		Either<Object, String> ee = Either.right(e);
		Either<Object, String> eo = Either.left(a);

		//set up list of eithers
		List<Either<Object, String>> input = new LinkedList<>();
		input.add(ae);
		input.add(be);
		input.add(ce);
		input.add(de);
		input.add(ee);
		input.add(eo);

		//set up expected list
		List<String> expectedRight = new LinkedList<>();
		expectedRight.add(a);
		expectedRight.add(b);
		expectedRight.add(c);
		expectedRight.add(d);
		expectedRight.add(e);

		List<Object> expectedLeft = new LinkedList<>();
		expectedLeft.add(a);

		Both<List<Object>, List<String>> expectedBoth = new Both<>(expectedLeft, expectedRight);

		Both<List<Object>, List<String>> actualBoth = Helpers.partitionEithers(input);

		assertEquals(expectedBoth, actualBoth);
	}

	/**
	 * test partitionEithers with null list
	 */
	@Test(expected = NullPointerException.class)
	public void partitionEithers_null(){
		Helpers.partitionEithers(null);
	}

	/**
	 * test partitionEithers with empty list
	 */
	@Test
	public void partitionEithers_Empty(){
		Both<List<String>,List<Object>> expected = new Both<>(new LinkedList<String>(), new LinkedList<Object>());
		Both<List<String>,List<Object>> actual =  Helpers.partitionEithers(new LinkedList<Either<String,Object>>());
		assertEquals(expected, actual);
	}
}
