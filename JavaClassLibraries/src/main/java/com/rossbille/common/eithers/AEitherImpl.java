package com.rossbille.common.eithers;

import java.util.function.Consumer;
import java.util.function.Function;


public class AEitherImpl<TLeft, TRight> extends AEither<TLeft, TRight> {

    @Override
    public <Out> Out match(Function<TLeft, Out> ofLeft, Function<TRight, Out> ofRight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void match(Consumer<TLeft> ofLeft, Consumer<TRight> ofRight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
