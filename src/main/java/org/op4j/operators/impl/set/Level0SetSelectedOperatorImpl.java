package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FSet;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0SetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetSelectedOperator<T> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<T> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.Insert<T>(position, newElements)));
    }


    public Level0SetSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllIndexes<T>(indexes)));
    }


    public Level0SetSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllEqual<T>(values)));
    }


    public Level0SetSelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0SetSelectedOperator<T> removeAllNull() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.RemoveAllNull<T>()));
    }


    public Level0SetSelectedOperator<T> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }


    public Level0SetOperator<T> endIf() {
        return new Level0SetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetSelectedOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level0SetSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T> add(final T newElement) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.Add<T>(newElement)));
    }


    public Level0SetSelectedOperator<T> addAll(final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.Add<T>(newElements)));
    }


    public Level0SetSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T> sort() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.Sort()));
    }


    public Level0SetSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().execute(new FSet.SortByComparator<T>(comparator)));
    }


    public Level0SetSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().map(Structure.SET, function, null));
    }


    public Level0SetSelectedOperator<T> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
