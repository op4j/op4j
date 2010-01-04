package org.op4j.operators.impl.setofarray;

import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> endIf() {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
