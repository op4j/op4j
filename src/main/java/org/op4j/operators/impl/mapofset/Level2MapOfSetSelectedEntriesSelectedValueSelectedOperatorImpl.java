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
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate(Structure.SET));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> convertAsSet(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.SET));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> evalAsSet(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.SET));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> execAsSet(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> add(final V newElement) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().map(Structure.SET, function, null));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
