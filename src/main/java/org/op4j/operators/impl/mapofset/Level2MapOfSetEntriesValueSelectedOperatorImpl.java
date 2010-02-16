package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesValueSelectedOperator<K,V> {


    public Level2MapOfSetEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate(Structure.SET));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> mapIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }


    public Level2MapOfSetEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> execIfNotNullAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> execAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> add(final V newElement) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().map(Structure.SET, function, null));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
