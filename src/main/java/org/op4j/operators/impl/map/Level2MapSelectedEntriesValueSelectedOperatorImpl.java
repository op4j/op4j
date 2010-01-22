package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapSelectedEntriesValueSelectedOperator<K,V,I> {


    public Level2MapSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapSelectedEntriesValueOperator<K,V,I> endIf() {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }


    public Operation<Map<K,V>,I> createOperation() {
        return endIf().createOperation();
    }



}
