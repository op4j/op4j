package org.op4j.operators.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetElementsSelectedOperator<T,I> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetElementsOperator<T,I> endIf() {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }


    public Operation<Set<T>,I> createOperation() {
        return endIf().createOperation();
    }



}
