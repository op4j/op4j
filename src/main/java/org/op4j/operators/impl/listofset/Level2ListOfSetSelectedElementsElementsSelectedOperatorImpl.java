package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsElementsSelectedOperator<T,I> {


    public Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T,I> endIf() {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }


    public Operation<List<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
