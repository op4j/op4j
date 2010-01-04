package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> {


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
