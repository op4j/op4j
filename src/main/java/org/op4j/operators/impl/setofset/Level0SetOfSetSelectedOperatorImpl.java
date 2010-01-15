package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfSetSelectedOperator<T> {


    public Level0SetOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsOperator<T> forEach() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0SetOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0SetOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public Level0SetOfSetSelectedOperator<T> removeNulls() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<Set<T>>()));
    }


    public Level0SetOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0SetOfSetOperator<T> endIf() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(newElements)));
    }


    public Level0SetOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0SetOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T> sort() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0SetOfSetSelectedOperator<T> exec(final IFunction<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> function) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0SetOfSetSelectedOperator<T> convert(final IConverter<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> converter) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
