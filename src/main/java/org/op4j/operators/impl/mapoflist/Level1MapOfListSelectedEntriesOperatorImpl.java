package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapOfListSelectedEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfListSelectedEntriesOperator<K,V,I> {


    public Level1MapOfListSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_LIST));
    }


    public Level0MapOfListSelectedOperator<K,V,I> endFor() {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfListSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> onKey() {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V,I> onValue() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> function) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> replaceWith(final Entry<K,List<V>> replacement) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> converter) {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
