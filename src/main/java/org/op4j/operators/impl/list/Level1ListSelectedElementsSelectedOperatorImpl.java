package org.op4j.operators.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ListSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListSelectedElementsSelectedOperator<T,I> {


    public Level1ListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListSelectedElementsOperator<T,I> endIf() {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }


    public Operation<List<T>,I> createOperation() {
        return endIf().createOperation();
    }



}
