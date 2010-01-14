package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public T[][] get() {
        return endIf().get();
    }



}
