package org.op4j.operators.impl.listofarray;

import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T[]> get() {
        return null;
    }



}
