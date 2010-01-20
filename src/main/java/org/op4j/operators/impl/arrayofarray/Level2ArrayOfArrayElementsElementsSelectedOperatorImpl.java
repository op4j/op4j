package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArrayElementsElementsSelectedOperator<T> {


    private final Type<? extends T> type;


    public Level2ArrayOfArrayElementsElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public T[][] get() {
        return endIf().get();
    }



}
