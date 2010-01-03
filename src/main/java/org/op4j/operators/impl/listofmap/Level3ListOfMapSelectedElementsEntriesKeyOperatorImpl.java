package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> {


    public Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
