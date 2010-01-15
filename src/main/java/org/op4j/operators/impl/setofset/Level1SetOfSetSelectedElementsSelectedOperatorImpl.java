package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfSetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsSelectedOperator<T> {


    public Level1SetOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfSetSelectedElementsOperator<T> endIf() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsSelectedOperator<T> sort() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
