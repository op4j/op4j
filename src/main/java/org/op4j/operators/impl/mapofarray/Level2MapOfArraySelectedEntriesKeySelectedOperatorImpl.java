package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.arrayOf, getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
