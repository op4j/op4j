package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesKeySelectedOperator<K,V,I> {


    public Level2MapOfArrayEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArrayEntriesKeyOperator<K,V,I> endIf() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
