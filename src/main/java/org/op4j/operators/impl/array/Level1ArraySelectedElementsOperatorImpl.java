package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ArraySelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArraySelectedElementsOperator<T,I> {


    private final Type<? extends T> type;


    public Level1ArraySelectedElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArraySelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level0ArraySelectedOperator<T,I> endFor() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level1ArraySelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArraySelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArraySelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[] get() {
        return endFor().get();
    }


    public Operation<T[],I> createOperation() {
        return endFor().createOperation();
    }



}
