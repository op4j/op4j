package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfListElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListElementsElementsSelectedOperator<T> {


    public Level2ArrayOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ArrayOfListElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfListElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
