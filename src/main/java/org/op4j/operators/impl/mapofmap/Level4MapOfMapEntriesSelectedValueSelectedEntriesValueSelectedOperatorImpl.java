package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> replaceWith(final V replacement) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
