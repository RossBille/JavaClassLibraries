package com.rossbille.common.eithers;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author RossBille
 */
public abstract class AEither<TLeft,TRight> {
    public abstract <Out> Out match(Function<TLeft,Out> ofLeft, Function<TRight,Out> ofRight);
    public abstract void match(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight);
}
