package com.rossbille.common.functions;

/**
 *
 * @author rossbille
 */
public interface Action<Argument>
{
	void invoke(Argument argument);	
}
