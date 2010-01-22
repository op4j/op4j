package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> {


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> endIf() {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> replaceWith(final V replacement) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
