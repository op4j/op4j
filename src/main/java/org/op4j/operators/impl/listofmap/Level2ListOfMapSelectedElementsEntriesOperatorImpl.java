package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;


public class Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2ListOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> endFor() {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
