package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endIf() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfSetSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> converter) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
