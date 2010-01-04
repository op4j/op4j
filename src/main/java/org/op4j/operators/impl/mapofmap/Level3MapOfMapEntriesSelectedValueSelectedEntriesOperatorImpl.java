package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> {


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K2,V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> endFor() {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<K2,V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<K2,V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
