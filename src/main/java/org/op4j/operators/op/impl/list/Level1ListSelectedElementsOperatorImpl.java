package org.op4j.operators.op.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<List<T>>, Level1ListSelectedElementsOperator<T,I> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperatorImpl<T,I> endFor() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public List<T> get() {
        return endFor().get();
    }



}
