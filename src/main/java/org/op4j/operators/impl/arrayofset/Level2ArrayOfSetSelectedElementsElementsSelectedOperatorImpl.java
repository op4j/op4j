package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T,I> {


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T,I> endIf() {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T>[] get() {
        return endIf().get();
    }


    public Operation<Set<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
