package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesSelectedValueEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapEntriesSelectedValueEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
