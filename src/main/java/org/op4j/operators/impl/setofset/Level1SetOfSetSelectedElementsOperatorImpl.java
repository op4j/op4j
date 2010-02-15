package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1SetOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsOperator<T> {


    public Level1SetOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1SetOfSetSelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> removeAllNull() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level0SetOfSetSelectedOperator<T> endFor() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level1SetOfSetSelectedElementsOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level1SetOfSetSelectedElementsOperator<T> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T> add(final T newElement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T> sort() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetSelectedElementsOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().map(Structure.SET, function, null));
    }


    public Level1SetOfSetSelectedElementsOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }



}
