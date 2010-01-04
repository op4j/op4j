package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level1ArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArraySelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ArraySelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> endFor() {
        return null;
    }


    public Level1ArraySelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level1ArraySelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public T[] get() {
        return null;
    }



}
