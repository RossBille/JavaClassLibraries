package com.rossbille.common.eithers;

import java.util.function.Function;
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
public class EitherTest{

	public EitherTest(){
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
	 * test to make sure Either.left(null) throws an IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testLeft_null(){
		Either.left(null);
	}

	/**
	 * test to make sure EIther.right(null) throws an IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRight_null(){
		Either.right(null);
	}

	/**
	 * tests match with a null function to ensure it throws an IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void match_nullFunction(){
		Either<String, Integer> either = Either.left("test'");
		either.match(null, (Integer t) -> {
			return t.toString();
		});
	}

	/**
	 * tests match with a null function to ensure it throws an IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void match_nullConsumer(){
		Either<String, Integer> either = Either.left("test'");
		either.match(null, (Integer t) -> {
			String toString = t.toString();
		});
	}
}
