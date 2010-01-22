package org.op4j.operators.impl.generic;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0GenericUniqSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0GenericUniqSelectedOperator<T,I> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level0GenericUniqOperator<T,I> endIf() {
        return new Level0GenericUniqOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0GenericUniqSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0GenericUniqSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public T get() {
        return endIf().get();
    }


    public Operation<T,I> createOperation() {
        return endIf().createOperation();
    }



}
