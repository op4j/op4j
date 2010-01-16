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
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfSetElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return endIf().get();
    }



}
