package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetSelectedOperator<T> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<T> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0SetSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0SetSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0SetOperator<T> endIf() {
        return new Level0SetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level0SetSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level0SetSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level0SetSelectedOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T> sort() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level0SetSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T> get() {
        return null;
    }



}
