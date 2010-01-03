package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetSelectedElementsOperator<T> {


    public Level1ArrayOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> endFor() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return null;
    }


    public Set<T>[] get() {
        return null;
    }



}
