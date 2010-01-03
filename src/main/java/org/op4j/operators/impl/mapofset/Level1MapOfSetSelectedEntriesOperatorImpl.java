package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level1MapOfSetSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesOperator<K,V> {


    public Level1MapOfSetSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level0MapOfSetSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> function) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
