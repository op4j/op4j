package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> endIf() {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> execAsMapEntry(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
