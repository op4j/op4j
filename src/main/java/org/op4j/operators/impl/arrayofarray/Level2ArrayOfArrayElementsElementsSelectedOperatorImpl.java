package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArrayElementsElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ArrayOfArrayElementsElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public T[][] get() {
        return null;
    }



}
