package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> endFor() {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(null));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> execAsMapEntry(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
