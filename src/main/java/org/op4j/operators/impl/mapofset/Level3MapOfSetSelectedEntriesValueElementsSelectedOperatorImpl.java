package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> {


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> endIf() {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
