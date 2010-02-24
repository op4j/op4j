package org.op4j.operators.impl.fn.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,T[]>, Level1ArraySelectedElementsSelectedOperator<I,T> {


    private final Type<T> type;


    public Level1ArraySelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperatorImpl<I,T> endIf() {
        return new Level1ArraySelectedElementsOperatorImpl<I,T>(this.type, getTarget().endSelect());
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
