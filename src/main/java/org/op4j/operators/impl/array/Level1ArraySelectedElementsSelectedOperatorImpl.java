package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ArraySelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArraySelectedElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level1ArraySelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArraySelectedElementsOperator<T,I> endIf() {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[] get() {
        return endIf().get();
    }


    public Operation<T[],I> createOperation() {
        return endIf().createOperation();
    }



}
