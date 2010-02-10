package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> {


    public Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> endFor() {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().endIterate(null));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level4MapOfMapEntriesSelectedValueEntriesValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapEntriesSelectedValueEntriesValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> execAsMapEntry(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
