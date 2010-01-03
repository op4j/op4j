package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> {


    public Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
