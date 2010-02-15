package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsElementsOperator<T> {


    public Level2SetOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetOfListSelectedElementsOperator<T> endFor() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }



}
