package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
