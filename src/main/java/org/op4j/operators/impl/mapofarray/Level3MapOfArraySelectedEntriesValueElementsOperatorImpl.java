package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesValueElementsOperator<K,V,I> {


    private final Type<? extends V> type;


    public Level3MapOfArraySelectedEntriesValueElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNull() {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V,I> endFor() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endFor().createOperation();
    }



}
