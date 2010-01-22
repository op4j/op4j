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
import org.op4j.target.Target.Normalization;


public class Level1MapEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapEntriesSelectedOperator<K,V> {


    public Level1MapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1MapEntriesOperator<K,V> endIf() {
        return new Level1MapEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level1MapEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1MapEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
