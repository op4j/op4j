package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfSetEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> {


    public Level3MapOfSetEntriesSelectedValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
