package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level1MapOfMapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> endIf() {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return new Level2MapOfMapSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> replaceWith(final Entry<K1,Map<K2,V>> replacement) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAPENTRY_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
