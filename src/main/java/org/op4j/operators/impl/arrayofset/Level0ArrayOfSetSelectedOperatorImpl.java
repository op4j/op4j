package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfSetSelectedOperator<T> {


    public Level0ArrayOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> forEach() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ArrayOfSetSelectedOperator<T> distinct() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeNulls() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<Set<T>>()));
    }


    public Level0ArrayOfSetSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>[],? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ArrayOfSetOperator<T> endIf() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ArrayOfSetSelectedOperator<T> add(final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(newElements)));
    }


    public Level0ArrayOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0ArrayOfSetSelectedOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T> sort() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfSetSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>[],? super Set<T>[]> function) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0ArrayOfSetSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>[],? super Set<T>[]> converter) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T>[] get() {
        return endIf().get();
    }



}
