package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesKeySelectedOperator<K,V> {


    public Level2MapOfSetEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfSetEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfSetEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfSetEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfSetEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
