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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedValueOperator<K,V> {


    public Level2MapOfSetEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
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


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfSetEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indices)));
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


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.SET));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.SET));
    }


    public Map<K,Set<V>> get() {
        return endOn().get();
    }



}
