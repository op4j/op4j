package org.op4j.operators.impl.fn.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,Set<T>>, Level1SetSelectedElementsOperator<I,T> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperatorImpl<I,T> endFor() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }



}
