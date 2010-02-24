package org.op4j.operators.op.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.list.Level1ListElementsOperator;
import org.op4j.operators.op.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListElementsSelectedOperator<T,I> {


    public Level1ListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListElementsOperator<T,I> endIf() {
        return new Level1ListElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1ListElementsSelectedOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}