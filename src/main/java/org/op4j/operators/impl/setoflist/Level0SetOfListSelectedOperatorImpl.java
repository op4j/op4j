package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfListSelectedOperator<T> {


    public Level0SetOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> distinct() {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeEquals(final List<T>... values) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> eval(final IEvaluator<? extends Set<List<T>>,? super Set<List<T>>> eval) {
        return null;
    }


    public Level0SetOfListOperator<T> endIf() {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> add(final List<T>... newElements) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> exec(final IFunction<? extends Set<List<T>>,? super Set<List<T>>> function) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> sort() {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> convert(final IConverter<? extends Set<List<T>>,? super Set<List<T>>> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
