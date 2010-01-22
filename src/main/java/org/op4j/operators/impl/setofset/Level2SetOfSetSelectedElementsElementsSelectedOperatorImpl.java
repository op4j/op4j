package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsElementsSelectedOperator<T,I> {


    public Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T,I> endIf() {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
