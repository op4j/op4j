package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedValueOperator<K,V,I> {


    public Level2MapOfSetEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNotNull() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V,I> forEach() {
        return new Level3MapOfSetEntriesSelectedValueElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> removeAllNull() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> eval(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V,I> endOn() {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> add(final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> exec(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> sort() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> convert(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.SET));
    }


    public Map<K,Set<V>> get() {
        return endOn().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
