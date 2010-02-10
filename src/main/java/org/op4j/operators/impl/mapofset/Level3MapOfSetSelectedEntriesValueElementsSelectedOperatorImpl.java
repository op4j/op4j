package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> {


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> endIf() {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
