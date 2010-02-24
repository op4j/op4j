package org.op4j.operators.impl.op.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<Set<T>,I>, Level1SetSelectedElementsSelectedOperator<T,I> {


    public Level1SetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperatorImpl<T,I> endIf() {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
