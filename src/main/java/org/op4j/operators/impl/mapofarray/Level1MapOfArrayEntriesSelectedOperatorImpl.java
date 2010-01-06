package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level1MapOfArrayEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArrayEntriesSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level1MapOfArrayEntriesSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1MapOfArrayEntriesOperator<K,V> endIf() {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(this.arrayOf, getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
