package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> {


    public Level2MapOfMapEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNull() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNull() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> insertAll(final int position, final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.InsertAll<K2,V>(position, map)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> eval(final IEvaluator<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V,I> forEachEntry() {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().iterate());
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> removeAllKeys(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K2,V>(keys)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> removeAllKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K2,V>(keys)));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> endOn() {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Put<K2,V>(newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> putAll(final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.PutAll<K2,V>(map)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Insert<K2,V>(position, newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> exec(final IFunction<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> sort() {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> replaceWith(final Map<K2,V> replacement) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> convert(final IConverter<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
