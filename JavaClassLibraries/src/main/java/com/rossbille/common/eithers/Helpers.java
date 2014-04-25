package com.rossbille.common.eithers;

import java.util.LinkedList;
import java.util.List;

/**
 * functions to aid in working with Eithers and Boths
 * @author rossbille
 */
public class Helpers
{
	/**
	 * Takes a list of Eithers and separates them into a Both 
	 * that contains a List of Lefts and a list of Rights
	 * @param <TLeft> the left type
	 * @param <TRight> the right type
	 * @param eithers the list of eithers to partition
	 * @return Both<List<Tleft>,List<TRight>> 
	 */
	public static<TLeft,TRight> Both<List<TLeft>,List<TRight>> partitionEithers(List<Either<TLeft,TRight>> eithers){
		List<TRight> rights = new LinkedList<>();
		List<TLeft> lefts = new LinkedList<>();
		
		eithers.stream().forEach((either) ->
		{
			either.Case(
					(TLeft argument) -> lefts.add(argument), 
					(TRight argument) -> rights.add(argument)
			);
		});
		return new Both<>(lefts, rights);
	}
}
