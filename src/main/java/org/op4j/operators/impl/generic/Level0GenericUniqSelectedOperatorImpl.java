package org.op4j.operators.impl.generic;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.target.Target;


public class Level0GenericUniqSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericUniqSelectedOperator<T> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0GenericUniqOperator<T> endIf() {
        return new Level0GenericUniqOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0GenericUniqSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public T get() {
        return null;
    }



}