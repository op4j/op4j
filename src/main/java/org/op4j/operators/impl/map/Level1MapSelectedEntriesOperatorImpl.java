package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapSelectedEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapSelectedEntriesOperator<K,V,I> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level0MapSelectedOperator<K,V,I> endFor() {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V,I> onKey() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapSelectedEntriesValueOperator<K,V,I> onValue() {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V> get() {
        return endFor().get();
    }


    public Operation<Map<K,V>,I> createOperation() {
        return endFor().createOperation();
    }



}
