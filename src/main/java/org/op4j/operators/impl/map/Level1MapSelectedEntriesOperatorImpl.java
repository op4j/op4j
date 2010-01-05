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
import org.op4j.target.Target.Structure;


public class Level1MapSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapSelectedEntriesOperator<K,V> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0MapSelectedOperator<K,V> endFor() {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V> get() {
        return null;
    }



}
