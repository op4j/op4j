package org.op4j.operators.impl.fn.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,Set<T>>, Level1SetElementsSelectedOperator<I,T> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsOperatorImpl<I,T> endIf() {
        return new Level1SetElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
