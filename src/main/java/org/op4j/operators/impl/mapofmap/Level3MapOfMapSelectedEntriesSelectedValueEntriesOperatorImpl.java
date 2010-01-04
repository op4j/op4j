package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator;
import org.op4j.target.Target;


public class Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K2,V>,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V> endFor() {
        return null;
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<K2,V>,? super Entry<K2,V>> function) {
        return null;
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<K2,V>,? super Entry<K2,V>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
