package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[][] get() {
        return endIf().get();
    }


    public Operation<T[][],I> createOperation() {
        return endIf().createOperation();
    }



}
