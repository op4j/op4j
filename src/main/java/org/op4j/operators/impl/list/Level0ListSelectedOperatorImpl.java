package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListSelectedOperator<T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ListSelectedOperator<T> distinct() {
        return null;
    }


    public Level0ListSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ListSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ListSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level0ListOperator<T> endIf() {
        return null;
    }


    public Level0ListSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level0ListSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level0ListSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level0ListSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level0ListSelectedOperator<T> sort() {
        return null;
    }


    public Level0ListSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level0ListSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public List<T> get() {
        return null;
    }



}
