package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfArrayElementsSelectedElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T[]> get() {
        return endIf().get();
    }


    public Operation<Set<T[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
