package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesKeyOperator<K,V> {


    public Level2MapOfSetSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> replaceBy(final K replacement) {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V>(getTarget().replaceBy(replacement));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endOn() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,Set<V>> get() {
        return endOn().get();
    }



}
