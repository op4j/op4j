package org.op4j.operators.f.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.op.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.op.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListSelectedElementsOperator<T,I> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> endFor() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endFor().get();
    }



}
