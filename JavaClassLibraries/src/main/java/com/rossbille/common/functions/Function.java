package com.rossbille.common.functions;

/**
 *
 * @author rossbille
 * @param <In>
 * @param <Out>
 */
public interface Function<In, Out>
{
	Out apply(In argument);	
}
