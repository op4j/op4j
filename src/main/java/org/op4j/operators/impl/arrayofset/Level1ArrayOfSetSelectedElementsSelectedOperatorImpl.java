package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetSelectedElementsSelectedOperator<T> {


    public Level1ArrayOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> removeAllNull() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().map(Structure.SET, function, null));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Set<T>[] get() {
        return endIf().get();
    }



}
