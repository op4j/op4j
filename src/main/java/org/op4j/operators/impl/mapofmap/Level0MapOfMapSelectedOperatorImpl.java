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
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level0MapOfMapSelectedOperator<K1,K2,V,I> {


    public Level0MapOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> insertAll(final int position, final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.InsertAll<K1,Map<K2,V>>(position, NormalizationUtils.normalizeMapOfMap(map))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAP_OF_MAP));
    }


    public Level0MapOfMapOperator<K1,K2,V,I> endIf() {
        return new Level0MapOfMapOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level1MapOfMapEntriesOperator<K1,K2,V,I> forEachEntry() {
        return new Level1MapOfMapEntriesOperatorImpl<K1,K2,V,I>(getTarget().iterate());
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> removeAllKeys(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> removeAllKeysNot(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Put<K1,Map<K2,V>>(newKey, NormalizationUtils.normalizeMap(newValue))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> putAll(final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.PutAll<K1,Map<K2,V>>(NormalizationUtils.normalizeMapOfMap(map))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.Insert<K1,Map<K2,V>>(position, newKey, NormalizationUtils.normalizeMap(newValue))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> function) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAP_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfMapSelectedOperator<K1,K2,V,I> sort() {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> sort(final Comparator<? super Entry<K1,Map<K2,V>>> comparator) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(new MapFuncs.SortEntries<K1,Map<K2,V>>(comparator)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> replaceWith(final Map<K1,Map<K2,V>> replacement) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> converter) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAP_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
