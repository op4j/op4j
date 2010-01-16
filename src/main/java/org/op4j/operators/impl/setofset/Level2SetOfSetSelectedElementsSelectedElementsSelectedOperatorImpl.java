package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> {


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
