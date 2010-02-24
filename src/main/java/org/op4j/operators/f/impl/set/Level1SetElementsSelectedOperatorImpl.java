package org.op4j.operators.f.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.set.Level1SetElementsOperator;
import org.op4j.operators.op.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetElementsSelectedOperator<T,I> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsOperator<T,I> endIf() {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetElementsSelectedOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}