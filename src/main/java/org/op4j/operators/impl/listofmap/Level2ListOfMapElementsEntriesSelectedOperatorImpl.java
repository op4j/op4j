package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapElementsEntriesSelectedOperator<K,V> {


    public Level2ListOfMapElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2ListOfMapElementsEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
