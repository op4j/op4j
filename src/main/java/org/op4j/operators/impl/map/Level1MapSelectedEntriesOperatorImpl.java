package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level1MapSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapSelectedEntriesOperator<K,V> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1MapSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level0MapSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return null;
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return null;
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level1MapSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Map<K,V> get() {
        return null;
    }



}
