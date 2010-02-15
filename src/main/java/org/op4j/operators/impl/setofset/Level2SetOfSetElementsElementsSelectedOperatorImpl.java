package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfSetElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetElementsElementsSelectedOperator<T> {


    public Level2SetOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2SetOfSetElementsElementsOperator<T> endIf() {
        return new Level2SetOfSetElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
