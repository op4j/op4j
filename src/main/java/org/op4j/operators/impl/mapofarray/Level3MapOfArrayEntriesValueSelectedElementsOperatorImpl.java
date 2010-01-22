package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V,I> {


    private final Type<? extends V> type;


    public Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNull() {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V,I> endFor() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endFor().createOperation();
    }



}
