package org.op4j.operators.f.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.op.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.op.intf.array.Level1ArraySelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArraySelectedElementsOperator<T,I> {


    private final Type<T> type;


    public Level1ArraySelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifIndex(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArraySelectedOperator<T,I> endFor() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level1ArraySelectedElementsOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endFor().get();
    }



}
