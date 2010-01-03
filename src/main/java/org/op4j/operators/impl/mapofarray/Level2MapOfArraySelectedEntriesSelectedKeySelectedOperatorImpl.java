package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
