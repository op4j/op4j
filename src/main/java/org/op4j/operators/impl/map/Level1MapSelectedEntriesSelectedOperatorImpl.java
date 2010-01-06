package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapSelectedEntriesSelectedOperator<K,V> {


    public Level1MapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapSelectedEntriesOperator<K,V> endIf() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
