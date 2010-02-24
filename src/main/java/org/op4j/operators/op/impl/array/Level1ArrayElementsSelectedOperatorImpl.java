package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsOperator<T> endIf() {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
