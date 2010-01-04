package org.op4j.operators.impl.map;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level2MapEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapEntriesSelectedValueOperator<K,V> {


    public Level2MapEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level1MapEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level2MapEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,V> get() {
        return null;
    }



}
