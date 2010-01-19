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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapOfListSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListSelectedEntriesOperator<K,V> {


    public Level1MapOfListSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> replaceBy(final Entry<K,List<V>> replacement) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().replaceBy(replacement));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY_OF_LIST));
    }


    public Level0MapOfListSelectedOperator<K,V> endFor() {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> onValue() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> function) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> converter) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }



}
