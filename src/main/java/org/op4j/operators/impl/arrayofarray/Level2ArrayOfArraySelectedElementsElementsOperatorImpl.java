package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ArrayOfArraySelectedElementsElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public T[][] get() {
        return null;
    }



}
