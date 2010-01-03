package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeyOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
