package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesKeyOperator<K,V> {


    public Level2MapSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1MapSelectedEntriesOperator<K,V> endOn() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
