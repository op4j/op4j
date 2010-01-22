package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T,I> {


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T>[] get() {
        return endIf().get();
    }


    public Operation<Set<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
