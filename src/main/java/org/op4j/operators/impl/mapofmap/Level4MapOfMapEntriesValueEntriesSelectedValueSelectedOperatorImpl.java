package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level4MapOfMapEntriesValueEntriesSelectedValueOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesValueEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}