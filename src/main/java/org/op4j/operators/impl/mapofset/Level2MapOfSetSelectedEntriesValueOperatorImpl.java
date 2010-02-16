package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesValueOperator<K,V> {


    public Level2MapOfSetSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> forEach() {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().iterate(Structure.SET));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNullOrFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNotNullAndFalse(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNotNullAndTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNullOrTrue(final IFunction<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeAllNull() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endOn() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> execIfNotNullAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> execAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> add(final V newElement) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().map(Structure.SET, function, null));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Map<K,Set<V>> get() {
        return endOn().get();
    }



}
