package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(eval));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K,V> endIf() {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function));
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
