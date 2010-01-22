package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V,I> {


    private final Type<? extends V> type;


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V,I> endFor() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endFor().createOperation();
    }



}
