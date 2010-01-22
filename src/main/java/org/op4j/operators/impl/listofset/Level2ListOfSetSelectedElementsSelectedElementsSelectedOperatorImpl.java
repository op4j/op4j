package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> {


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }


    public Operation<List<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
