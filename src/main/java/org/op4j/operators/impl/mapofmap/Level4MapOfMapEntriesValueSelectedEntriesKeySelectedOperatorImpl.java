package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapEntriesValueSelectedEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
