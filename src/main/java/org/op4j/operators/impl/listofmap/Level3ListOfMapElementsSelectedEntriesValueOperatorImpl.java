package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> {


    public Level3ListOfMapElementsSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
