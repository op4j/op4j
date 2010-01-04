package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfListSelectedEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> {


    public Level3MapOfListSelectedEntriesSelectedValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListSelectedEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
