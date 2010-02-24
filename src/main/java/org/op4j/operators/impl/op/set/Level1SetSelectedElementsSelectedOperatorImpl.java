package org.op4j.operators.impl.op.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,Set<T>>, Level1SetSelectedElementsSelectedOperator<I,T> {


    public Level1SetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> endIf() {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
