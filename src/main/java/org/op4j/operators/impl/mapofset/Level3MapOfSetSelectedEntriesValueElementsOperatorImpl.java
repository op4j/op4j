package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> {


    public Level3MapOfSetSelectedEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNull() {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V,I> endFor() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
