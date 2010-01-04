package org.op4j.operators.impl.arrayofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> {


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> endIf() {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return null;
    }



}
