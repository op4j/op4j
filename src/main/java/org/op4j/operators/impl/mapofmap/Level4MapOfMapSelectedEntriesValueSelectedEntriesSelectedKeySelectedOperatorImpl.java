package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> {


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperator<K1,K2,V,I> endIf() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> replaceWith(final K2 replacement) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
