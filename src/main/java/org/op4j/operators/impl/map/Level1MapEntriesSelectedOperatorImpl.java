package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapEntriesSelectedOperator<K,V> {


    public Level1MapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1MapEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level2MapEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level1MapEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Map<K,V> get() {
        return null;
    }



}
