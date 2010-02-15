package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> execIfNotNull(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
