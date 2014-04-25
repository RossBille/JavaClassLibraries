package com.rossbille.common.eithers;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;



/**
 *
 * @author rossbille
 * @param <TLeft>
 * @param <TRight>
 */
public class Both<TLeft,TRight>
{
	private final TLeft left;
	private final TRight right;

	public Both(TLeft left, TRight right)
	{
		if(left == null || right == null){
			throw new IllegalArgumentException("expected both left and right values.");
		}
		this.left = left;
		this.right = right;
	}
	
	public void leftAction(Consumer<TLeft> ofLeft){
		ofLeft.accept(left);
	}
	public void rightAction(Consumer<TRight> ofRight){
		ofRight.accept(right);
	}
	public void bothActions(BiConsumer<TLeft,TRight> consumer){
		consumer.accept(left, right);
	}
	public<Out> Out leftFunction(Function<TLeft,Out> ofLeft){
		return ofLeft.apply(left);
	}
	public<Out> Out rightFunction(Function<TRight,Out> ofRight){
		return ofRight.apply(right);
	}
	public<Out> Out bothFunctions(BiFunction<TLeft,TRight,Out> function){
		return function.apply(left, right);
	}
	
}
