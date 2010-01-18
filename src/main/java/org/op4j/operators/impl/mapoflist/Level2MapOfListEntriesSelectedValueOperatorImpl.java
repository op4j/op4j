package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfListEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedValueOperator<K,V> {


    public Level2MapOfListEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfListEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends List<? extends V>,? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends List<? extends V>,? super List<V>> converter) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.LIST));
    }


    public Map<K,List<V>> get() {
        return endOn().get();
    }



}
