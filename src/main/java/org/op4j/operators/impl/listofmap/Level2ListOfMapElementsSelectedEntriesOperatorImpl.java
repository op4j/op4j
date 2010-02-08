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
import org.op4j.target.Target.Normalisation;


public class Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2ListOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> endFor() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level3ListOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ListOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return new Level3ListOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAPENTRY));
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAPENTRY));
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAPENTRY));
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }



}
