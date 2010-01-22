package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfListElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfListElementsElementsSelectedOperator<T,I> {


    public Level2SetOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfListElementsElementsOperator<T,I> endIf() {
        return new Level2SetOfListElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
