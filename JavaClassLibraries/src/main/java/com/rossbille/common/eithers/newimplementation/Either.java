package com.rossbille.common.eithers.newimplementation;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * An Either is an object that can contain either a value of type TLeft or TRight but never both.
 * By convention an Either contains a right value if a function has executed successfully and left otherwise
 *
 * @author RossBille
 * @param <TLeft> the type of the left value
 * @param <TRight> the type of the right value
 */
public interface Either<TLeft,TRight>{
	/**
	 * Runs ofLeft if this either contains a left value or ofRight if it contains a right value
	 *
	 * @throws IllegalArgumentException if either actions are null
	 * @param ofLeft the action to run if this either contains a left value
	 * @param ofRight the action to run if this either contains a right value
	 */
    void match(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight);
	
	/**
	 * Applies ofLeft if this either contains a left value or ofRight if it contains a right value
	 *
	 * @throws IllegalArgumentException if either functions are null
	 * @param <Out> the return type
	 * @param ofLeft the function to run if this either contains a left value
	 * @param ofRight the function to run if this either contains a right value
	 *
	 * @return the result of the function that is applied of type Out
	 */
	<Out> Out match(Function<TLeft,Out> ofLeft, Function<TRight,Out> ofRight);	
}
