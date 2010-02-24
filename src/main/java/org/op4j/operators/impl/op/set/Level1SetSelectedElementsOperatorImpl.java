package org.op4j.operators.impl.op.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<Set<T>>, Level1SetSelectedElementsOperator<T,I> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<T,I> endFor() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().endIterate(null));
    }


    public Level1SetSelectedElementsOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }



}
