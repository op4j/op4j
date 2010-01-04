package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesOperator<K1,K2,V> {


    public Level1MapOfMapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return null;
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> endFor() {
        return null;
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfMapSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> function) {
        return null;
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<K1,Map<K2,V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
