package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedKeyOperator<K,V> {


    public Level2MapOfArrayEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }



}
