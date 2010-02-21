package org.op4j.operators.impl.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericMultiSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericMultiSelectedOperator<T> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiOperator<T> endIf() {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0GenericMultiSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
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


    public int size() {
        return endIf().size();
    }



}
