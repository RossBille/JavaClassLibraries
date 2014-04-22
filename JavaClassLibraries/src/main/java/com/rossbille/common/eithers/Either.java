package com.rossbille.common.eithers;

import com.rossbille.common.functions.Action;
import com.rossbille.common.functions.Function;

public class Either<TLeft,TRight>
{
	private final TLeft left;
	private final TRight right;
 
	public static <TLeft> Either left(TLeft value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		return new Either(value, null);
	}

	public static <TRight> Either right(TRight value) {
		if (value == null) {
			throw new IllegalArgumentException();
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
	
	
	public void Case(Action<TLeft> ofLeft, Action<TRight> ofRight){
		if(ofLeft == null){
			throw new IllegalArgumentException("ofLeft");
		}
		if(ofRight == null){
			throw new IllegalArgumentException("ofRight");
		}
		if(isLeft()){
			ofLeft.invoke(left);
		}else{
			ofRight.invoke(right);
		}
	}
	
	public<Out> Out Case(Function<TLeft,Out> ofLeft, Function<TRight,Out> ofRight){
		if(ofLeft == null){
			throw new IllegalArgumentException("ofLeft");
		}
		if(ofRight == null){
			throw new IllegalArgumentException("ofRight");
		}
		if(isLeft()){
			return (Out) ofLeft.apply(left);
		}else{
			return (Out) ofRight.apply(right);
		}
	}
}
