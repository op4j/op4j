package org.op4j.operators.impl.op.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FList;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ListSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<List<T>,I>, Level0ListSelectedOperator<T,I> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<T,I> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperatorImpl<T,I> distinct() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Distinct<T>()));
    }


    public Level0ListSelectedOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllEqual<T>(values)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListSelectedOperatorImpl<T,I> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.RemoveAllNull<T>()));
    }


    public Level0ListSelectedOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    public Level0ListOperatorImpl<T,I> endIf() {
        return new Level0ListOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level0ListSelectedOperatorImpl<T,I> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<T,I> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<T,I> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Add<T>(newElement)));
    }


    public Level0ListSelectedOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Add<T>(newElements)));
    }


    public Level0ListSelectedOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<T,I> sort() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.Sort()));
    }


    public Level0ListSelectedOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new FList.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperatorImpl<T,I> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<T,I> map(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().map(Structure.LIST, function, null));
    }


    public List<T> get() {
        return endIf().get();
    }



}
