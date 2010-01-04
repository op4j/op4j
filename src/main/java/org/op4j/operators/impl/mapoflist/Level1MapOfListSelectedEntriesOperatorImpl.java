package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level1MapOfListSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListSelectedEntriesOperator<K,V> {


    public Level1MapOfListSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> eval) {
        return null;
    }


    public Level0MapOfListSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> function) {
        return null;
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
