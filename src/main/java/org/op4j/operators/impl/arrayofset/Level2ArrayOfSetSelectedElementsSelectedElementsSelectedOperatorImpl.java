package org.op4j.operators.impl.arrayofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> {


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return null;
    }



}
