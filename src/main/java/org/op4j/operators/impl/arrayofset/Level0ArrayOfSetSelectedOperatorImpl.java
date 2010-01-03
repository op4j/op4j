package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfSetSelectedOperator<T> {


    public Level0ArrayOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> distinct() {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<T>[],? super Set<T>[]> eval) {
        return null;
    }


    public Level0ArrayOfSetOperator<T> endIf() {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> exec(final IFunction<? extends Set<T>[],? super Set<T>[]> function) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> sort() {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return null;
    }


    public Level0ArrayOfSetSelectedOperator<T> convert(final IConverter<? extends Set<T>[],? super Set<T>[]> converter) {
        return null;
    }


    public Set<T>[] get() {
        return null;
    }



}
