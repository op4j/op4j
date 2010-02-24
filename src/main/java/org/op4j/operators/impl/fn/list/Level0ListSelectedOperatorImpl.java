package org.op4j.operators.impl.fn.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FList;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ListSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,List<T>>, Level0ListSelectedOperator<I,T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> distinct() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Distinct<T>()));
    }


    public Level0ListSelectedOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllEqual<T>(values)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.RemoveAllNull<T>()));
    }


    public Level0ListSelectedOperatorImpl<I,T> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    public Level0ListOperatorImpl<I,T> endIf() {
        return new Level0ListOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0ListSelectedOperatorImpl<I,T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Add<T>(newElement)));
    }


    public Level0ListSelectedOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Add<T>(newElements)));
    }


    public Level0ListSelectedOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> sort() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.Sort()));
    }


    public Level0ListSelectedOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(new FList.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperatorImpl<I,T> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> map(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().map(Structure.LIST, function, null));
    }


    public List<T> get() {
        return endIf().get();
    }



}
