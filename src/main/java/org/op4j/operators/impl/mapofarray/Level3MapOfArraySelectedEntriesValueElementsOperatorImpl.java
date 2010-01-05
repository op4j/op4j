package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArraySelectedEntriesValueElementsOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> endFor() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY,  this.arrayOf.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
