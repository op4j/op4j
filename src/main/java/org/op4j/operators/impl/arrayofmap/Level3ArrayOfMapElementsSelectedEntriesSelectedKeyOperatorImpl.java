package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
