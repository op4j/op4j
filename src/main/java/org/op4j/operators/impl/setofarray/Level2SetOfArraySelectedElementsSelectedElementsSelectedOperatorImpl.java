package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> {


    private final Type<? extends T> type;


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
