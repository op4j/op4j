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
import org.op4j.target.Target.Structure;


public class Level1MapOfSetSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesOperator<K,V> {


    public Level1MapOfSetSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0MapOfSetSelectedOperator<K,V> endFor() {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> converter) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
