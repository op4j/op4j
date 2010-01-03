package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfSetEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetEntriesSelectedOperator<K,V> {


    public Level1MapOfSetEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> eval) {
        return null;
    }


    public Level1MapOfSetEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> function) {
        return null;
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,Set<V>>,? super Entry<K,Set<V>>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
