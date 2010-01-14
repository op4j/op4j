package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2SetOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> endFor() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return new Level3SetOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return endFor().get();
    }



}
