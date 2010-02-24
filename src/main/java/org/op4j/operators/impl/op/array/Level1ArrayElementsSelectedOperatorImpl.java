package org.op4j.operators.impl.op.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArrayElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,T[]>, Level1ArrayElementsSelectedOperator<I,T> {


    private final Type<T> type;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsOperatorImpl<I,T> endIf() {
        return new Level1ArrayElementsOperatorImpl<I,T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ArrayElementsSelectedOperatorImpl<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
