package org.op4j.operators.op.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArrayElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<T[]>, Level1ArrayElementsSelectedOperator<T,I> {


    private final Type<T> type;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsOperatorImpl<T,I> endIf() {
        return new Level1ArrayElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
