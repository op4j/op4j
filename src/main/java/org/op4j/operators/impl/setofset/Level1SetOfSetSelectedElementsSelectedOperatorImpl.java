package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfSetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsSelectedOperator<T> {


    public Level1SetOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> endIf() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return null;
    }


    public Set<Set<T>> get() {
        return null;
    }



}
