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
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> {


    public Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> insertAll(final int position, final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.InsertAll<K2,V>(position, map)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> endIf() {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> forEachEntry() {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().iterate());
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> removeAllKeys(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K2,V>(keys)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> removeAllKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K2,V>(keys)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Put<K2,V>(newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> putAll(final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.PutAll<K2,V>(map)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Insert<K2,V>(position, newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> sort() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> replaceWith(final Map<K2,V> replacement) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
