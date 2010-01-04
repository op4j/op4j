package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
