package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}