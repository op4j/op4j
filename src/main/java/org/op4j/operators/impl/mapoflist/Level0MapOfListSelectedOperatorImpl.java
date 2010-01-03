package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level0MapOfListSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfListSelectedOperator<K,V> {


    public Level0MapOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfListSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,List<V>>,? super Map<K,List<V>>> eval) {
        return null;
    }


    public Level0MapOfListOperator<K,V> endIf() {
        return null;
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> insertAll(final int position, final Map<K,List<V>> map) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> put(final K newKey, final List<V> newValue) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> putAll(final Map<K,List<V>> map) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> insert(final int position, final K newKey, final List<V> newValue) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> exec(final IFunction<? extends Map<K,List<V>>,? super Map<K,List<V>>> function) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> sort() {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> sort(final Comparator<? super Entry<K,List<V>>> comparator) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> convert(final IConverter<? extends Map<K,List<V>>,? super Map<K,List<V>>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
