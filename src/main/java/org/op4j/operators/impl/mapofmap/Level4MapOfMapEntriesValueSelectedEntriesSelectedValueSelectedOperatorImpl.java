package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> {


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> replaceBy(final V replacement) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().replaceBy(replacement));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V> endIf() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
