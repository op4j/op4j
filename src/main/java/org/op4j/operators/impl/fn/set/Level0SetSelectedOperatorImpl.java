package org.op4j.operators.impl.fn.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FSet;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0SetSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,Set<T>>, Level0SetSelectedOperator<I,T> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetSelectedOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.Insert<T>(position, newElements)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllIndexes<T>(indexes)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllEqual<T>(values)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNull() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.RemoveAllNull<T>()));
    }


    public Level0SetSelectedOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }


    public Level0SetOperatorImpl<I,T> endIf() {
        return new Level0SetOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0SetSelectedOperatorImpl<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level0SetSelectedOperatorImpl<I,T> execAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> add(final T newElement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.Add<T>(newElement)));
    }


    public Level0SetSelectedOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.Add<T>(newElements)));
    }


    public Level0SetSelectedOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> sort() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.Sort()));
    }


    public Level0SetSelectedOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(new FSet.SortByComparator<T>(comparator)));
    }


    public Level0SetSelectedOperatorImpl<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().map(Structure.SET, function, null));
    }


    public Level0SetSelectedOperatorImpl<I,T> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Function<I,Set<T>> get() {
        return endIf().get();
    }



}
