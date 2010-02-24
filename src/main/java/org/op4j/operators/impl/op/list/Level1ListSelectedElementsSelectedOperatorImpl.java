package org.op4j.operators.impl.op.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,List<T>>, Level1ListSelectedElementsSelectedOperator<I,T> {


    public Level1ListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> endIf() {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}
