package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfArrayElementsSelectedElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T,I> endIf() {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public List<T[]> get() {
        return endIf().get();
    }


    public Operation<List<T[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
