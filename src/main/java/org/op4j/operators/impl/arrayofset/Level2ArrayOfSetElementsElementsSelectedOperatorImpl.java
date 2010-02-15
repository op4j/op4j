package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetElementsElementsSelectedOperator<T> {


    public Level2ArrayOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ArrayOfSetElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T>[] get() {
        return endIf().get();
    }



}
