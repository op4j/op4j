package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level3MapOfArrayEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> endFor() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY,  this.arrayOf.getRawClass()));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
