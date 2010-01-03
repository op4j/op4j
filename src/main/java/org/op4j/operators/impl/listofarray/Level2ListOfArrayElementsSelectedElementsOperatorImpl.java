package org.op4j.operators.impl.listofarray;

import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfArrayElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArrayElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ListOfArrayElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T[]> get() {
        return null;
    }



}
