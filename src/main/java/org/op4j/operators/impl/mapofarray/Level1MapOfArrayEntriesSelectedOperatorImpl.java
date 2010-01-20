package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfArrayEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArrayEntriesSelectedOperator<K,V> {


    public Level1MapOfArrayEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesOperator<K,V> endIf() {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
