package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
