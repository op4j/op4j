package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ListOfArrayElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArrayElementsElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ListOfArrayElementsElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfArrayElementsElementsOperator<T> endIf() {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
