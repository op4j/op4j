package org.op4j.operators.impl.fn.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqFnOperator<List<T>,I>, Level1ListSelectedElementsSelectedOperator<T,I> {


    public Level1ListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<T,I> endIf() {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}
