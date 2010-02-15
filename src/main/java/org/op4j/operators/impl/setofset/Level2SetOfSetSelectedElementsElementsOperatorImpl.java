package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfSetSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsElementsOperator<T> {


    public Level2SetOfSetSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetOfSetSelectedElementsOperator<T> endFor() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }



}
