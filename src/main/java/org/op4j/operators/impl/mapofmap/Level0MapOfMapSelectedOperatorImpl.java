package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
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
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K1,Map<K2,V>>> eval) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K1,Map<K2,V>>,? super Map<K1,Map<K2,V>>> eval) {
        return null;
    }


    public Level0MapOfMapOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level1MapOfMapEntriesOperator<K1,K2,V> forEachEntry() {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeKeys(final K1... keys) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> removeKeysNot(final K1... keys) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<K1,Map<K2,V>>,? super Map<K1,Map<K2,V>>> function) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> sort() {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K1,Map<K2,V>>> comparator) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<K1,Map<K2,V>>,? super Map<K1,Map<K2,V>>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
