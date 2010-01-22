package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfSetEntriesKeySelectedOperator<K,V,I> {


    public Level2MapOfSetEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfSetEntriesKeyOperator<K,V,I> endIf() {
        return new Level2MapOfSetEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
