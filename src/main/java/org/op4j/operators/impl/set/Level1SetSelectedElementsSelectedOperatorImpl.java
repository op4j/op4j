package org.op4j.operators.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetSelectedElementsSelectedOperator<T,I> {


    public Level1SetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetSelectedElementsOperator<T,I> endIf() {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }


    public Operation<Set<T>,I> createOperation() {
        return endIf().createOperation();
    }



}
