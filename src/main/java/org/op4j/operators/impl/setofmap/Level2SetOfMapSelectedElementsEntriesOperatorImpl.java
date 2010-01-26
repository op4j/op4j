package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2SetOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> endFor() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return new Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Set<Map<K,V>> get() {
        return endFor().get();
    }



}
