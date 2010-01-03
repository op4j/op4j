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
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T>[] get() {
        return null;
    }



}
