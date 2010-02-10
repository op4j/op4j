package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListElementsSelectedElementsSelectedOperator<T> {


    public Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfListElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfListElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
