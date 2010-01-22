package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> {


    public Level2SetOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V,I> endFor() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V,I> onKey() {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V,I> onValue() {
        return new Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Set<Map<K,V>> get() {
        return endFor().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
