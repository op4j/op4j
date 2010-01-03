package org.op4j.operators.impl.setofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfSetSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsElementsOperator<T> {


    public Level2SetOfSetSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<Set<T>> get() {
        return null;
    }



}
