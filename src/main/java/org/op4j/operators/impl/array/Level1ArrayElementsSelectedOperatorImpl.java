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


    private final Type<? super T> arrayOf;


    public Level1ArrayElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ArrayElementsOperator<T> endIf() {
        return new Level1ArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level1ArrayElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level1ArrayElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[] get() {
        return endIf().get();
    }



}
