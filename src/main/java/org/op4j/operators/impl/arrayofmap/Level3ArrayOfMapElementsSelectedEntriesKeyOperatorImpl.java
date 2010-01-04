package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
