package org.op4j.operators.f.impl.generic;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericUniqSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0GenericUniqSelectedOperator<T,I> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqOperator<T,I> endIf() {
        return new Level0GenericUniqOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T get() {
        return endIf().get();
    }



}
