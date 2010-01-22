package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V,I> {


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V,I> endIf() {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
