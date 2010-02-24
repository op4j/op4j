package org.op4j.operators.impl.fn.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,List<T>>, Level1ListElementsSelectedOperator<I,T> {


    public Level1ListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListElementsOperatorImpl<I,T> endIf() {
        return new Level1ListElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1ListElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ListElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}
