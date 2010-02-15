package org.op4j.operators.impl.generic;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericUniqSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0GenericUniqSelectedOperator<T> {


    public Level0GenericUniqSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericUniqSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericUniqOperator<T> endIf() {
        return new Level0GenericUniqOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0GenericUniqSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericUniqSelectedOperator<T> replaceWith(final T replacement) {
        return new Level0GenericUniqSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T get() {
        return endIf().get();
    }



}
