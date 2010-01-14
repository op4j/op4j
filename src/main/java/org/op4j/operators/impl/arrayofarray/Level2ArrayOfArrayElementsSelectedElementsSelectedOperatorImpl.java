package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public T[][] get() {
        return endIf().get();
    }



}
