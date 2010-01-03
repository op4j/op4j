package org.op4j.operators.impl.setofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsSelectedElementsOperator<T> {


    public Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<Set<T>> get() {
        return null;
    }



}
