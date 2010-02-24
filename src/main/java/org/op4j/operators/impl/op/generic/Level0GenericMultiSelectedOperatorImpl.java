package org.op4j.operators.impl.op.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.operators.qualities.MultiOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericMultiSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements MultiOpOperator<T>, Level0GenericMultiSelectedOperator<T,I> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiOperatorImpl<T,I> endIf() {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0GenericMultiSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public T[] getAsArray(final Type<T> type) {
        return endIf().buildArrayOf(type).get();
    }


    public List<T> getAsList() {
        return endIf().buildList().get();
    }


    public Level0GenericMultiSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public int size() {
        return endIf().size();
    }



}
