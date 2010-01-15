package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.target.Target;


public class Level0MapOfArraySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfArraySelectedOperator<K,V> {


    public Level0MapOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfArraySelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveMatching<K,V[]>(eval)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,V[]>(eval)));
    }


    public Level0MapOfArraySelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0MapOfArrayOperator<K,V> endIf() {
        return new Level0MapOfArrayOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0MapOfArraySelectedOperator<K,V> insertAll(final int position, final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V[]>(position, map)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeKeys(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeys<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeKeysNot(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V[]>(newKey, newValue)));
    }


    public Level0MapOfArraySelectedOperator<K,V> putAll(final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V[]>(map)));
    }


    public Level0MapOfArraySelectedOperator<K,V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V[]>(position, newKey, newValue)));
    }


    public Level0MapOfArraySelectedOperator<K,V> sort(final Comparator<? super Entry<K,V[]>> comparator) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V[]>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfArraySelectedOperator<K,V> sort() {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfArraySelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level0MapOfArraySelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> converter) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
