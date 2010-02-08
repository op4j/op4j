package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> endIf() {
        return new Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> execAsMapEntry(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAPENTRY));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
