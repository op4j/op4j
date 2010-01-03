package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfListEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListEntriesSelectedOperator<K,V> {


    public Level1MapOfListEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> eval) {
        return null;
    }


    public Level1MapOfListEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> function) {
        return null;
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,List<V>>,? super Entry<K,List<V>>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
