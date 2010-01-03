package org.op4j.operators.impl.arrayofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetElementsElementsSelectedOperator<T> {


    public Level2ArrayOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T>[] get() {
        return null;
    }



}
