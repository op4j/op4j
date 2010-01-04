package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListElementsSelectedOperator<T> {


    public Level1ListOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListOfListElementsOperator<T> endIf() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfListElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListOfListElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<List<T>> get() {
        return null;
    }



}
