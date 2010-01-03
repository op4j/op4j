package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapElementsSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> {


    public Level3SetOfMapElementsSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
