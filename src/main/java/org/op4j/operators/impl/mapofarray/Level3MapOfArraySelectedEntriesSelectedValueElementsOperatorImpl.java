package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
