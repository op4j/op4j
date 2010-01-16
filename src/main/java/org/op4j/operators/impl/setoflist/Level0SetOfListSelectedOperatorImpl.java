package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfListSelectedOperator<T> {


    public Level0SetOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsOperator<T> forEach() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfListSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public Level0SetOfListSelectedOperator<T> removeEquals(final List<T>... values) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<List<T>>(values)));
    }


    public Level0SetOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<List<T>>(indices)));
    }


    public Level0SetOfListSelectedOperator<T> removeNulls() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<List<T>>()));
    }


    public Level0SetOfListSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0SetOfListOperator<T> endIf() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetOfListSelectedOperator<T> add(final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(newElements)));
    }


    public Level0SetOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<List<T>>(collection)));
    }


    public Level0SetOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T> sort() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0SetOfListSelectedOperator<T> exec(final IFunction<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> function) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0SetOfListSelectedOperator<T> convert(final IConverter<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> converter) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }



}
