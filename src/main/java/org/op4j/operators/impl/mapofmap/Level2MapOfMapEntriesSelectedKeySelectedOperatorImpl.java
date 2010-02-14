package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K1,? super K1> function) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> replaceWith(final K1 replacement) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
