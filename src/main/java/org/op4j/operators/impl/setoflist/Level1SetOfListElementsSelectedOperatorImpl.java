package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListElementsSelectedOperator<T> {


    public Level1SetOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level1SetOfListElementsOperator<T> endIf() {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1SetOfListElementsSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
