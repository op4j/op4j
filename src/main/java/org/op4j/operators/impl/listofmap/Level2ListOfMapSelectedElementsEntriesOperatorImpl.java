package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> {


    public Level2ListOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> endFor() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V,I> onKey() {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> onValue() {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
