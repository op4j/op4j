package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}