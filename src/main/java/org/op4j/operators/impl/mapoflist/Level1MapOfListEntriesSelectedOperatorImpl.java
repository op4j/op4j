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
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfListEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfListEntriesSelectedOperator<K,V> {


    public Level1MapOfListEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListEntriesOperator<K,V> endIf() {
        return new Level1MapOfListEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> execAsMapOfListEntry(final IFunction<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> function) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_OF_LIST_ENTRY));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> evalAsMapOfListEntry(final IEvaluator<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_OF_LIST_ENTRY));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> convertAsMapOfListEntry(final IConverter<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> converter) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_OF_LIST_ENTRY));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> replaceWith(final Entry<K,List<V>> replacement) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_LIST_ENTRY));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
