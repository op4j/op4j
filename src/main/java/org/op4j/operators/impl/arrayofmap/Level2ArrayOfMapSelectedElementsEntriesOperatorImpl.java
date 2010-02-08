package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAPENTRY));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> endFor() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return new Level3ArrayOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAPENTRY));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAPENTRY));
    }


    public Map<K,V>[] get() {
        return endFor().get();
    }



}
