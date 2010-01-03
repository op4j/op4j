package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> {


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
