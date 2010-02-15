package org.op4j.operators.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListElementsSelectedOperator<T> {


    public Level1ListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListElementsOperator<T> endIf() {
        return new Level1ListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}
