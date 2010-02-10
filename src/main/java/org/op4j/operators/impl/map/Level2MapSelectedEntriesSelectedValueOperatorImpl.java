package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesSelectedValueOperator<K,V> {


    public Level2MapSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
