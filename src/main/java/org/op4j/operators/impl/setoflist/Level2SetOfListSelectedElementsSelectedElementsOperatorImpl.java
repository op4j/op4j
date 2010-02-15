package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsSelectedElementsOperator<T> {


    public Level2SetOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> endFor() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }



}
