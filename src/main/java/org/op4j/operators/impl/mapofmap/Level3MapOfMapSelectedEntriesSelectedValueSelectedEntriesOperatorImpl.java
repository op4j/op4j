package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> endFor() {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().iterateIndex(0));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().iterateIndex(1));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
