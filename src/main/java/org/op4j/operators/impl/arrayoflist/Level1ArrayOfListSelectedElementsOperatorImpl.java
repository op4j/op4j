package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ArrayOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListSelectedElementsOperator<T> {


    public Level1ArrayOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> distinct() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeAllNull() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level0ArrayOfListSelectedOperator<T> endFor() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().endIterate(List.class));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> execIfNotNullAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsOperator<T> add(final T newElement) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsOperator<T> sort() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> replaceWith(final List<T> replacement) {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T>[] get() {
        return endFor().get();
    }



}
