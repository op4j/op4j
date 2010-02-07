package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public class Level0MapOfMapSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level0MapOfMapSelectedOperator<K1,K2,V> {


    public Level0MapOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.InsertAll<K1,Map<K2,V>>(position, NormalisationUtils.normaliseMapOfMap(map))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAP_OF_MAP));
    }


    public Level0MapOfMapOperator<K1,K2,V> endIf() {
        return new Level0MapOfMapOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level1MapOfMapEntriesOperator<K1,K2,V> forEachEntry() {
        return new Level1MapOfMapEntriesOperatorImpl<K1,K2,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllKeys(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeAllKeysNot(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Put<K1,Map<K2,V>>(newKey, NormalisationUtils.normaliseMap(newValue))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.PutAll<K1,Map<K2,V>>(NormalisationUtils.normaliseMapOfMap(map))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Insert<K1,Map<K2,V>>(position, newKey, NormalisationUtils.normaliseMap(newValue))));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> function) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfMapSelectedOperator<K1,K2,V> sort() {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K1,Map<K2,V>>> comparator) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K1,Map<K2,V>>(comparator)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> replaceWith(final Map<K1,Map<K2,V>> replacement) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> converter) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAP_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
