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


public class Level0GenericMultiSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericMultiSelectedOperator<T> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level0GenericMultiOperator<T> endIf() {
        return null;
    }


    public T[] getAsArray(final Type<T> type) {
        return null;
    }


    public List<T> getAsList() {
        return null;
    }


    public Level0GenericMultiSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level0GenericMultiSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public int size() {
        return ((List<?>) getTarget().get()).size();
    }



}
