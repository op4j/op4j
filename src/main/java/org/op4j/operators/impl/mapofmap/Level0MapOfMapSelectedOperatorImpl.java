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


public class Level0MapOfMapSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level0MapOfMapSelectedOperator<K1,K2,V> {


    public Level0MapOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveMatching<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K1,Map<K2,V>>(eval)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level0MapOfMapOperator<K1,K2,V> endIf() {
        return new Level0MapOfMapOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level1MapOfMapEntriesOperator<K1,K2,V> forEachEntry() {
        return new Level1MapOfMapEntriesOperatorImpl<K1,K2,V>(getTarget().iterate());
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.InsertAll<K1,Map<K2,V>>(position, map)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeKeys(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveKeys<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeKeysNot(final K1... keys) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K1,Map<K2,V>>(keys)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Put<K1,Map<K2,V>>(newKey, newValue)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.PutAll<K1,Map<K2,V>>(map)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Insert<K1,Map<K2,V>>(position, newKey, newValue)));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K1,Map<K2,V>>> comparator) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K1,Map<K2,V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfMapSelectedOperator<K1,K2,V> sort() {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> function) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<? extends K1,? extends Map<? extends K2,? extends V>>,? super Map<K1,Map<K2,V>>> converter) {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
