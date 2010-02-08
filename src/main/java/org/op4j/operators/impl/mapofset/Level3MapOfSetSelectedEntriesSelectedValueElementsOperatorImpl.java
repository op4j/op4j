package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> {


    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> endFor() {
        return new Level2MapOfSetSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }



}
