package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> {


    public Level3MapOfSetEntriesValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K,V> endIf() {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
