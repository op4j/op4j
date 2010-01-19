package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfListEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> replaceBy(final K replacement) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceBy(replacement));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
