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
import org.op4j.target.Target.Normalisation;


public class Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListSelectedEntriesSelectedOperator<K,V> {


    public Level1MapOfListSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> endIf() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfListSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfListSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> execAsMapOfListEntry(final IFunction<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> function) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> evalAsMapOfListEntry(final IEvaluator<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> convertAsMapOfListEntry(final IConverter<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> converter) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,List<V>> replacement) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
