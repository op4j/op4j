package org.op4j.operators.impl.arrayofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> {


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return null;
    }



}
