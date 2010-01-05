package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> {


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
