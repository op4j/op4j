package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfSetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfSetSelectedElementsSelectedOperator<T> {


    public Level1ListOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListOfSetSelectedElementsOperator<T> endIf() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsSelectedOperator<T> sort() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<Set<T>> get() {
        return null;
    }



}
