package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> {


    public Level1MapOfMapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_MAP));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V,I> endFor() {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfMapSelectedEntriesKeyOperator<K1,K2,V,I> onKey() {
        return new Level2MapOfMapSelectedEntriesKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V,I> onValue() {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> replaceWith(final Entry<K1,Map<K2,V>> replacement) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
