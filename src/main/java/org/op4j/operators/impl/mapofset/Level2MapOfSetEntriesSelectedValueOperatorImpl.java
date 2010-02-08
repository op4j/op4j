package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedValueOperator<K,V> {


    public Level2MapOfSetEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfSetEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().iterate(Structure.SET));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> convertAsSet(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.SET));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> evalAsSet(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.SET));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> execAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V> add(final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Map<K,Set<V>> get() {
        return endOn().get();
    }



}
