package org.op4j.operators.impl.arrayofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetSelectedElementsElementsOperator<T> {


    public Level2ArrayOfSetSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T>[] get() {
        return null;
    }



}
