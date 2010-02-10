package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> {


    public Level3MapOfSetSelectedEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> endFor() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }



}
