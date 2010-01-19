package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2ArrayOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> replaceBy(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().replaceBy(replacement));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> endFor() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V>[] get() {
        return endFor().get();
    }



}
