package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
