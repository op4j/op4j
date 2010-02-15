package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1SetOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsOperator<T> {


    public Level1SetOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> forEach() {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1SetOfListSelectedElementsOperator<T> distinct() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1SetOfListSelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeAllNull() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level0SetOfListSelectedOperator<T> endFor() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level1SetOfListSelectedElementsOperator<T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level1SetOfListSelectedElementsOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T> add(final T newElement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1SetOfListSelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T> sort() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfListSelectedElementsOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level1SetOfListSelectedElementsOperator<T> replaceWith(final List<T> replacement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }



}
