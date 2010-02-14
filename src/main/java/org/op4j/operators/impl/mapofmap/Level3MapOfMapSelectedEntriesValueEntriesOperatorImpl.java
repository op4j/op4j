package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> endFor() {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().endIterate(null));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapSelectedEntriesValueEntriesKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level4MapOfMapSelectedEntriesValueEntriesValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapSelectedEntriesValueEntriesValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> execAsMapEntry(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
