package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
