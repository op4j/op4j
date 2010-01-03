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


public class Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> {


    public Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K2,V>,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> endFor() {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueEntriesValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<K2,V>,? super Entry<K2,V>> function) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<K2,V>,? super Entry<K2,V>> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
