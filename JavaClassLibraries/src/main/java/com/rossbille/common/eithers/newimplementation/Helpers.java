package com.rossbille.common.eithers.newimplementation;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author rossbille
 */
public class Helpers{

	private static final class LeftImpl<TLeft, TRight> implements Either<TLeft, TRight>{

		private final TLeft value;
		
		@Override
		public void match(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight){
			if(ofLeft == null){
				throw new IllegalArgumentException("expected non-null ofLeft action");
			}
			ofLeft.accept(value);
		}

		@Override
		public <Out> Out match(Function<TLeft, Out> ofLeft, Function<TRight, Out> ofRight){
			if(ofLeft == null){
				throw new IllegalArgumentException("expected non-null ofLeft action");
			}
			return ofLeft.apply(value);
		}

		private LeftImpl(TLeft value){
			this.value = value;
		}
	}

	private static final class RightImpl<TLeft, TRight> implements Either<TLeft, TRight>{

		private final TRight value;

		/**
		 * Runs ofLeft if this either contains a left value
		 *
		 * @throws IllegalArgumentException if either actions are null
		 * @param ofLeft the action to run if this either contains a left value
		 * @param ofRight the action to run if this either contains a right value
		 */
		@Override
		public void match(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight){
			if(ofRight== null){
				throw new IllegalArgumentException("expected non-null ofLeft action");
			}
			ofRight.accept(value);
		}

		@Override
		public <Out> Out match(Function<TLeft, Out> ofLeft, Function<TRight, Out> ofRight){
			if(ofRight== null){
				throw new IllegalArgumentException("expected non-null ofLeft action");
			}
			return ofRight.apply(value);
		}

		private RightImpl(TRight value){
			this.value = value;
		}

	}

	/**
	 * Constructs a left type Either
	 *
	 * @param <TLeft> the left type of this Either
     * @param <TRight> the right type of this Either
	 * @param value the value this Either contains
	 *
	 * @return the constructed Either
	 */
	public static <TLeft, TRight> Either<TLeft, TRight> left(TLeft value){
		return new LeftImpl<>(value);
	}

	/**
	 * Constructs a right type Either
	 *
     * @param <TLeft> the left type of this either
	 * @param <TRight> the right type of this either
	 * @param value the value this Either contains
	 *
	 * @return the constructed either
	 */
	public static <TLeft, TRight> Either<TLeft, TRight> right(TRight value){
		return new RightImpl<>(value);
	}

}
