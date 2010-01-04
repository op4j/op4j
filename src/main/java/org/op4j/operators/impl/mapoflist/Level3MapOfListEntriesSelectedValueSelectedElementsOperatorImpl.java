package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> {


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
