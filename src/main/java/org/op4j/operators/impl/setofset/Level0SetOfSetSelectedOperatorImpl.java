package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfSetSelectedOperator<T> {


    public Level0SetOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> distinct() {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<Set<T>>,? super Set<Set<T>>> eval) {
        return null;
    }


    public Level0SetOfSetOperator<T> endIf() {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> exec(final IFunction<? extends Set<Set<T>>,? super Set<Set<T>>> function) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> sort() {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return null;
    }


    public Level0SetOfSetSelectedOperator<T> convert(final IConverter<? extends Set<Set<T>>,? super Set<Set<T>>> converter) {
        return null;
    }


    public Set<Set<T>> get() {
        return null;
    }



}
