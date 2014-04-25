package com.rossbille.common.eithers;

import java.util.function.Consumer;
import java.util.function.Function;
/**
 * An Either is an object that can contain either a value of type TLeft or TRight but never both
 * by convention an Either contains a right value if a function has executed successfully and left otherwise
 * @author rossbille
 * @param <TLeft>
 * @param <TRight> 
 */
public class Either<TLeft,TRight>
{
	private final TLeft left;
	private final TRight right;
 
	/**
	 * Constructs a left type Either
	 * @param <TLeft> The left type of this Either
	 * @param value the value this Either contains
	 * @return the constructed Either
	 */
	public static <TLeft> Either left(TLeft value) {
		if (value == null) {
			throw new IllegalArgumentException("expected non-null left value");
		}
		return new Either(value, null);
	}
	
	/**
	 * Constructs a right type Either
	 * @param <TRight> The right type of this either
	 * @param value the value this Either contains
	 * @return the constructed either
	 */
	public static <TRight> Either right(TRight value) {
		if (value == null) {
			throw new IllegalArgumentException("expected non-null left value");
		}
		return new Either(null, value);
	}
	
	private Either(TLeft left, TRight right) {
		this.left = left;
		this.right = right;
	}
	
	private boolean isLeft() {
		return left != null;
	}
	
	/**
	 * Runs ofLeft if this either contains a left value or ofRight if it contains a right value
	 * @throws IllegalArgumentException if either actions are null
	 * @param ofLeft the action to run if this either contains a left value
	 * @param ofRight the action to run if this either contains a right value
	 */
	public void Case(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight){
		if(ofLeft == null){
			throw new IllegalArgumentException("expected non-null ofLeft action");
		}
		if(ofRight == null){
			throw new IllegalArgumentException("expected non-null ofRight action");
		}
		if(isLeft()){
			ofLeft.accept(left);
		}else{
			ofRight.accept(right);
		}
	}
	
	/**
	 * Applies ofLeft if this either contains a left value or ofRight if it contains a right value
	 * @throws IllegalArgumentException if either functions are null
	 * @param <Out> the return type 
	 * @param ofLeft the function to run if this either contains a left value
	 * @param ofRight the function to run if this either contains a right value
	 * @return The result of the function that is applied of type Out
	 */
	public<Out> Out Case(Function<TLeft,Out> ofLeft, Function<TRight,Out> ofRight){
		if(ofLeft == null){
			throw new IllegalArgumentException("expected non-null ofLeft function");
		}
		if(ofRight == null){
			throw new IllegalArgumentException("expected non-null ofRight function");
		}
		if(isLeft()){
			return (Out) ofLeft.apply(left);
		}else{
			return (Out) ofRight.apply(right);
		}
	}
}
