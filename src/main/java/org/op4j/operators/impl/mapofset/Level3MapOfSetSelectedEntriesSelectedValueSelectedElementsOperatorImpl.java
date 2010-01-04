package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> {


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
