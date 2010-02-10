package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> endIf() {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
