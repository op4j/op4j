package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListSelectedElementsSelectedOperator<T> {


    public Level1ListOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsOperator<T> endIf() {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public List<List<T>> get() {
        return null;
    }



}
