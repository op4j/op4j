package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListSelectedOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ListOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfListSelectedOperator<T> {


    public Level0ListOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> distinct() {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeEquals(final List<T>... values) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> eval(final IEvaluator<? extends List<List<T>>,? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ListOfListOperator<T> endIf() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListOfListSelectedOperator<T> add(final List<T>... newElements) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return null;
    }


    public Level0ListOfListSelectedOperator<T> exec(final IFunction<? extends List<List<T>>,? super List<List<T>>> function) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfListSelectedOperator<T> sort() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ListOfListSelectedOperator<T> convert(final IConverter<? extends List<List<T>>,? super List<List<T>>> converter) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<List<T>> get() {
        return null;
    }



}
