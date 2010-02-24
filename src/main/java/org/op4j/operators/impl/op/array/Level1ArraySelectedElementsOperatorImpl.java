package org.op4j.operators.impl.op.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,T[]>, Level1ArraySelectedElementsOperator<I,T> {


    private final Type<T> type;


    public Level1ArraySelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<I,T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperatorImpl<I,T> endFor() {
        return new Level0ArraySelectedOperatorImpl<I,T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level1ArraySelectedElementsOperatorImpl<I,T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperatorImpl<I,T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsOperatorImpl<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endFor().get();
    }



}
