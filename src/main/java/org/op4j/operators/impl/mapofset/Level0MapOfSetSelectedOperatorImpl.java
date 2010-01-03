package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level0MapOfSetSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfSetSelectedOperator<K,V> {


    public Level0MapOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfSetSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,Set<V>>,? super Map<K,Set<V>>> eval) {
        return null;
    }


    public Level0MapOfSetOperator<K,V> endIf() {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> insertAll(final int position, final Map<K,Set<V>> map) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> put(final K newKey, final Set<V> newValue) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> putAll(final Map<K,Set<V>> map) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> insert(final int position, final K newKey, final Set<V> newValue) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> exec(final IFunction<? extends Map<K,Set<V>>,? super Map<K,Set<V>>> function) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> sort() {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> sort(final Comparator<? super Entry<K,Set<V>>> comparator) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> convert(final IConverter<? extends Map<K,Set<V>>,? super Map<K,Set<V>>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
