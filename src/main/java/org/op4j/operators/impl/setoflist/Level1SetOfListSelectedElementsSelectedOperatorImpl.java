package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsSelectedOperator<T> {


    public Level1SetOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> distinct() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfListSelectedElementsOperator<T> endIf() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsSelectedOperator<T> sort() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }



}
