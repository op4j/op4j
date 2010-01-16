package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsOperator<T> {


    public Level1SetOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeNulls() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.SET));
    }


    public Level0SetOfSetSelectedOperator<T> endFor() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T> sort() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.SET));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }



}
