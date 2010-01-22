package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V,I> {


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> endFor() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V,I> onKey() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesValueOperator<K,V,I> onValue() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V>[] get() {
        return endFor().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endFor().createOperation();
    }



}
