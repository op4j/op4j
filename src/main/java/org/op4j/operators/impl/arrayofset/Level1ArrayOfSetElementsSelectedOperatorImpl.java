package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfSetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetElementsSelectedOperator<T> {


    public Level1ArrayOfSetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ArrayOfSetElementsOperator<T> endIf() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return null;
    }



}
