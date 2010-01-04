package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArraySelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public T[][] get() {
        return null;
    }



}
