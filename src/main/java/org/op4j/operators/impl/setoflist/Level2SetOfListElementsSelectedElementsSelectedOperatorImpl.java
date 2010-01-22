package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> {


    public Level2SetOfListElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
