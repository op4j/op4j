package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> {


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T>[] get() {
        return endIf().get();
    }


    public Operation<Set<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
