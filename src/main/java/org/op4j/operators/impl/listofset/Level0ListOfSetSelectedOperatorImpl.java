package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0ListOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfSetSelectedOperator<T> {


    public Level0ListOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsOperator<T> forEach() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfSetSelectedOperator<T> distinct() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0ListOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0ListOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public Level0ListOfSetSelectedOperator<T> removeNulls() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<Set<T>>()));
    }


    public Level0ListOfSetSelectedOperator<T> eval(final IEvaluator<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST_OF_SET));
    }


    public Level0ListOfSetOperator<T> endIf() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(newElements)));
    }


    public Level0ListOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0ListOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, newElements)));
    }


    public Level0ListOfSetSelectedOperator<T> exec(final IFunction<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> function) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.LIST_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T> sort() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ListOfSetSelectedOperator<T> convert(final IConverter<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> converter) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST_OF_SET));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
