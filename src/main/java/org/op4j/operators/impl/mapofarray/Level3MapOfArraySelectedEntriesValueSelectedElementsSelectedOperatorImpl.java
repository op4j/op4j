package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.arrayOf, getTarget().endSelect());
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
