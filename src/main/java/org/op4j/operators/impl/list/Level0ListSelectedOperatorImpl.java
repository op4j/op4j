package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FList;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListSelectedOperator<T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<T> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperator<T> distinct() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Distinct<T>()));
    }


    public Level0ListSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllEqual<T>(values)));
    }


    public Level0ListSelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListSelectedOperator<T> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.RemoveAllNull<T>()));
    }


    public Level0ListSelectedOperator<T> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    public Level0ListOperator<T> endIf() {
        return new Level0ListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListSelectedOperator<T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Add<T>(newElement)));
    }


    public Level0ListSelectedOperator<T> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Add<T>(newElements)));
    }


    public Level0ListSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> sort() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.Sort()));
    }


    public Level0ListSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new FList.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level0ListSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }



}
