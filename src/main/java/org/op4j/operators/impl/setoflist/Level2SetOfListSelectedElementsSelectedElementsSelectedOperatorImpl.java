package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> {


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
