package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public T[][] get() {
        return endIf().get();
    }



}
