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


public class Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
