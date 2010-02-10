package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
