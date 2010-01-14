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


public class Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesOperator<K1,K2,V> endIf() {
        return new Level3MapOfMapEntriesValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().iterateIndex(0));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().iterateIndex(1));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level3MapOfMapEntriesValueSelectedEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
