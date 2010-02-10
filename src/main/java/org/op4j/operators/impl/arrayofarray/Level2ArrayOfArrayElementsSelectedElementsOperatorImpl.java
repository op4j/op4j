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
import org.op4j.target.Target.Normalisation;


public class Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArrayElementsSelectedElementsOperator<T> {


    private final Type<T> type;


    public Level2ArrayOfArrayElementsSelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public T[][] get() {
        return endFor().get();
    }



}
