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


public class Level2ListOfArrayElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArrayElementsElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ListOfArrayElementsElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T[]> get() {
        return null;
    }



}
