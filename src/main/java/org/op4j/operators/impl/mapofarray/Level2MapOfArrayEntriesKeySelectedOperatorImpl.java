package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesKeySelectedOperator<K,V> {


    private final Type<V> type;


    public Level2MapOfArrayEntriesKeySelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfArrayEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
