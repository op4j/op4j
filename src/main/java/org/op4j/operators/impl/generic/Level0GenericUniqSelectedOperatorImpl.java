package org.op4j.operators.impl.generic;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0GenericUniqSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericUniqSelectedOperator<T> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqSelectedOperator<T> replaceBy(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level0GenericUniqSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level0GenericUniqOperator<T> endIf() {
        return new Level0GenericUniqOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0GenericUniqSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public T get() {
        return endIf().get();
    }



}
