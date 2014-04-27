package com.rossbille.common.eithers;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A Both is an object that contains both an object of type TLeft and an object of type TRight
 *
 * @author rossbille
 * @param <TLeft> the type of the left value
 * @param <TRight> the type of the right value
 */
public class Both<TLeft, TRight>{

	private final TLeft left;
	private final TRight right;

	/**
	 * Construct a Both
	 *
	 * @throws IllegalArgumentException if either of the values are null
	 * @param left the left value
	 * @param right the right value
	 */
	public Both(TLeft left, TRight right){
		if(left == null || right == null){
			throw new IllegalArgumentException("expected both left and right values.");
		}
		this.left = left;
		this.right = right;
	}

	/**
	 * Run an action with this both's left value
	 *
	 * @param ofLeft the Consumer to run on the left value
	 */
	public void leftAction(Consumer<TLeft> ofLeft){
		ofLeft.accept(left);
	}

	/**
	 * Run an action with this both's right value
	 *
	 * @param ofRight the Consumer to run on the right value
	 */
	public void rightAction(Consumer<TRight> ofRight){
		ofRight.accept(right);
	}

	/**
	 * Run an action with both of this both's values
	 *
	 * @param consumer the Consumer to run on both of the contained objects
	 */
	public void bothActions(BiConsumer<TLeft, TRight> consumer){
		consumer.accept(left, right);
	}

	/**
	 * Run a function on the left value
	 *
	 * @param <Out>	the return type
	 * @param ofLeft the function to run
	 *
	 * @return the result of the function
	 */
	public <Out> Out leftFunction(Function<TLeft, Out> ofLeft){
		return ofLeft.apply(left);
	}

	/**
	 * Run a function on the right value
	 *
	 * @param <Out> the return type
	 * @param ofRight the function to run
	 *
	 * @return the result of the supplied function
	 */
	public <Out> Out rightFunction(Function<TRight, Out> ofRight){
		return ofRight.apply(right);
	}

	/**
	 * Run a function on both contained values
	 *
	 * @param <Out> the return type
	 * @param function the function to run
	 *
	 * @return the result of the function
	 */
	public <Out> Out bothFunctions(BiFunction<TLeft, TRight, Out> function){
		return function.apply(left, right);
	}

	@Override
	public int hashCode(){
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.left);
		hash = 83 * hash + Objects.hashCode(this.right);
		return hash;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}

		final Both<?, ?> other = (Both<?, ?>) obj;
		if(!Objects.equals(this.left, other.left)){
			return false;
		}
		if(!Objects.equals(this.right, other.right)){
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		return "{left: " + left + ", right: " + right + '}';
	}

}
