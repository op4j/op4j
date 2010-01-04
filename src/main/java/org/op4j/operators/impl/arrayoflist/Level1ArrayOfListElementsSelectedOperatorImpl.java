package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListElementsSelectedOperator<T> {


    public Level1ArrayOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ArrayOfListElementsOperator<T> endIf() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfListElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ArrayOfListElementsSelectedOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T>[] get() {
        return null;
    }



}
