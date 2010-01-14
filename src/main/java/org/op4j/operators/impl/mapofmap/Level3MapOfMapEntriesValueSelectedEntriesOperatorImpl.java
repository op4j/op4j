package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> {


    public Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1,K2,V> endFor() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().iterateIndex(0));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapEntriesValueSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().iterateIndex(1));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
