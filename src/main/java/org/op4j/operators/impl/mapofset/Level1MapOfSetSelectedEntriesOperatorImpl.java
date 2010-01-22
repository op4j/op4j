package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesOperator<K,V,I> {


    public Level1MapOfSetSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_SET));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> endFor() {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V,I> onKey() {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V,I> onValue() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_SET));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V,I> replaceWith(final Entry<K,Set<V>> replacement) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> converter) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_SET));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
