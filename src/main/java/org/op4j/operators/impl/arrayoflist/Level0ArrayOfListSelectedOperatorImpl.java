package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfListSelectedOperator<T> {


    public Level0ArrayOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> distinct() {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeEquals(final List<T>... values) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> eval(final IEvaluator<? extends List<T>[],? super List<T>[]> eval) {
        return null;
    }


    public Level0ArrayOfListOperator<T> endIf() {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> add(final List<T>... newElements) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> exec(final IFunction<? extends List<T>[],? super List<T>[]> function) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> sort() {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> convert(final IConverter<? extends List<T>[],? super List<T>[]> converter) {
        return null;
    }


    public List<T>[] get() {
        return null;
    }



}
