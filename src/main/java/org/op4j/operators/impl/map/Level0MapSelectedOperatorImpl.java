package org.op4j.operators.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0MapSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0MapSelectedOperator<K,V,I> {


    public Level0MapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level0MapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level0MapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level0MapSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level0MapOperator<K,V,I> endIf() {
        return new Level0MapOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level1MapSelectedEntriesOperator<K,V,I> forEachEntry() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0MapSelectedOperator<K,V,I> removeAllKeys(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level0MapSelectedOperator<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level0MapSelectedOperator<K,V,I> put(final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level0MapSelectedOperator<K,V,I> putAll(final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level0MapSelectedOperator<K,V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level0MapSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<K,V,I> sort() {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapSelectedOperator<K,V,I> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level0MapSelectedOperator<K,V,I> replaceWith(final Map<K,V> replacement) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public Map<K,V> get() {
        return endIf().get();
    }


    public Operation<Map<K,V>,I> createOperation() {
        return endIf().createOperation();
    }



}
