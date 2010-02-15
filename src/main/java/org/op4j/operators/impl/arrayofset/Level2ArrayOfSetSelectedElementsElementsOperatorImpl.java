package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsElementsOperator<T> {


    public Level2ArrayOfSetSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> endFor() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T>[] get() {
        return endFor().get();
    }



}
