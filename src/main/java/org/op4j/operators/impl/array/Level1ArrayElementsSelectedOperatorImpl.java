package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.target.Target;


public class Level1ArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayElementsSelectedOperator<T> {


    private final Type<? extends T> type;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level1ArrayElementsOperator<T> endIf() {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    public Level1ArrayElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public T[] get() {
        return endIf().get();
    }



}
