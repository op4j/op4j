package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate(Structure.LIST));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> execIfNotNullAsList(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> execAsList(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> add(final V newElement) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<V>(newElement)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().map(Structure.LIST, function, null));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final List<V> replacement) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
