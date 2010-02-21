package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> endFor() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
