package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArrayElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ArrayOfArrayElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[][] get() {
        return null;
    }



}
