package org.op4j.operators.impl.op.generic;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericUniqSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<T>, Level0GenericUniqSelectedOperator<T,I> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqOperatorImpl<T,I> endIf() {
        return new Level0GenericUniqOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public T get() {
        return endIf().get();
    }



}
