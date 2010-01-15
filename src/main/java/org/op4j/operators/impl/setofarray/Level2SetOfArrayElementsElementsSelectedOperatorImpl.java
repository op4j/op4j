package org.op4j.operators.impl.setofarray;

import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfArrayElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArrayElementsElementsSelectedOperator<T> {


    private final Type<? extends T> type;


    public Level2SetOfArrayElementsElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level2SetOfArrayElementsElementsOperator<T> endIf() {
        return new Level2SetOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
