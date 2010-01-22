package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfSetElementsElementsSelectedOperator<T,I> {


    public Level2SetOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfSetElementsElementsOperator<T,I> endIf() {
        return new Level2SetOfSetElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
