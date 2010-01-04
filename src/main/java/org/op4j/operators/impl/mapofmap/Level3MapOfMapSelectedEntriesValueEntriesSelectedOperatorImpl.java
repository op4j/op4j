package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<K2,V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> endIf() {
        return new Level3MapOfMapSelectedEntriesValueEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return null;
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<K2,V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<K2,V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
