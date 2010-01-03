package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesSelectedOperator<K,V> {


    public Level1MapOfSetSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> function) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
