package org.op4j.operators.impl.arrayoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> {


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T>[] get() {
        return null;
    }



}