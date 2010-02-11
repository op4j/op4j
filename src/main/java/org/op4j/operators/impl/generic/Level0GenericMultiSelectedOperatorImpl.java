package org.op4j.operators.impl.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level0GenericMultiSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericMultiSelectedOperator<T> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level0GenericMultiOperator<T> endIf() {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endSelect());
    }


    public T[] getAsArray(final Type<T> type) {
        return endIf().buildArrayOf(type).get();
    }


    public List<T> getAsList() {
        return endIf().buildList().get();
    }


    public Level0GenericMultiSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperator<T> replaceWith(final T replacement) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public int size() {
        return endIf().size();
    }



}
