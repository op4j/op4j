package org.op4j.operators.impl.fn.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqFnOperator<Set<T>,I>, Level1SetElementsSelectedOperator<T,I> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsOperatorImpl<T,I> endIf() {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetElementsSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
