package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsEntriesSelectedKeyOperator<K,V> {


    public Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}