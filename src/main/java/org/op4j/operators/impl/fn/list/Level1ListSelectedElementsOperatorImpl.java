package org.op4j.operators.impl.fn.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,List<T>>, Level1ListSelectedElementsOperator<I,T> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<I,T> endFor() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public List<T> get() {
        return endFor().get();
    }



}
