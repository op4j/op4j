package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ArrayElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArrayElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArrayElementsOperator<T,I> endIf() {
        return new Level1ArrayElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArrayElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArrayElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[] get() {
        return endIf().get();
    }


    public Operation<T[],I> createOperation() {
        return endIf().createOperation();
    }



}
