package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2ListOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
