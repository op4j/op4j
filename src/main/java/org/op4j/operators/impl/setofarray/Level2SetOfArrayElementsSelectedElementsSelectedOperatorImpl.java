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


public class Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> endIf() {
        return null;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T[]> get() {
        return null;
    }



}
