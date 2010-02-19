package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FList;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfListEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedValueOperator<K,V> {


    public Level2MapOfListEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfListEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().iterate(Structure.LIST));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Distinct<V>()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Insert<V>(position, newElements)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.RemoveAllNull<V>()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> mapIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> execIfNotNullAsList(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> execAsList(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.LIST));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesSelectedValueOperator<K,V> add(final V newElement) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Add<V>(newElement)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Add<V>(newElements)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesSelectedValueOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Insert<V>(position, newElement)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.SortByComparator<V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new FList.Sort()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().map(Structure.LIST, function, null));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> replaceWith(final List<V> replacement) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Map<K,List<V>> get() {
        return endOn().get();
    }



}
