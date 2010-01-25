package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapOfArraySelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArraySelectedEntriesOperator<K,V> {


    public Level1MapOfArraySelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level0MapOfArraySelectedOperator<K,V> endFor() {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> onKey() {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> onValue() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
