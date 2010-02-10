package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> endIf() {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
