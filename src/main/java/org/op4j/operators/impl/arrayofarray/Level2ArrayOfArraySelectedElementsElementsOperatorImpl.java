package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsElementsOperator<T,I> {


    private final Type<? extends T> type;


    public Level2ArrayOfArraySelectedElementsElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> endFor() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(org.javaruntype.type.Types.arrayOf(this.type), getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[][] get() {
        return endFor().get();
    }


    public Operation<T[][],I> createOperation() {
        return endFor().createOperation();
    }



}
