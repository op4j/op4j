package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListSelectedEntriesSelectedOperator<K,V> {


    public Level1MapOfListSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> eval) {
        return null;
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> function) {
        return null;
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
