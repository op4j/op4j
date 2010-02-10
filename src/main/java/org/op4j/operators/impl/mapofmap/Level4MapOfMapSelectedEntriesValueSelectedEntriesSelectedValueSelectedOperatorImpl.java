package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> replaceWith(final V replacement) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
