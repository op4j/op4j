package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetSelectedElementsSelectedOperator<T> {


    public Level1ArrayOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return null;
    }



}
