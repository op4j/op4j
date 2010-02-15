package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsElementsSelectedOperator<T> {


    public Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> endIf() {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
