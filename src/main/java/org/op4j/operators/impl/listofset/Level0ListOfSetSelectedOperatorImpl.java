package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ListOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfSetSelectedOperator<T> {


    public Level0ListOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> distinct() {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> eval(final IEvaluator<? extends List<Set<T>>,? super List<Set<T>>> eval) {
        return null;
    }


    public Level0ListOfSetOperator<T> endIf() {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> exec(final IFunction<? extends List<Set<T>>,? super List<Set<T>>> function) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> sort() {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return null;
    }


    public Level0ListOfSetSelectedOperator<T> convert(final IConverter<? extends List<Set<T>>,? super List<Set<T>>> converter) {
        return null;
    }


    public List<Set<T>> get() {
        return null;
    }



}
