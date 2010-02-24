package org.op4j.operators.op.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<T[]>, Level1ArraySelectedElementsOperator<T,I> {


    private final Type<T> type;


    public Level1ArraySelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifIndex(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifIndexNot(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<T,I> endFor() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level1ArraySelectedElementsOperatorImpl<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperatorImpl<T,I> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperatorImpl<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public T[] get() {
        return endFor().get();
    }



}
