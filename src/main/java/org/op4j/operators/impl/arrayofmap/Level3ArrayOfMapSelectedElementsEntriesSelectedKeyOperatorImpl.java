package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
