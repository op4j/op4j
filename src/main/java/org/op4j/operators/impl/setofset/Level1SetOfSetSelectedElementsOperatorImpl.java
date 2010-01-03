package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsOperator<T> {


    public Level1SetOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> endFor() {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1SetOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return null;
    }


    public Set<Set<T>> get() {
        return null;
    }



}
