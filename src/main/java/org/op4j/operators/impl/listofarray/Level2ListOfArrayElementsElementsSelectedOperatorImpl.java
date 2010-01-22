package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfArrayElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfArrayElementsElementsSelectedOperator<T,I> {


    private final Type<? extends T> type;


    public Level2ListOfArrayElementsElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfArrayElementsElementsOperator<T,I> endIf() {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public List<T[]> get() {
        return endIf().get();
    }


    public Operation<List<T[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
