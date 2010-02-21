package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
