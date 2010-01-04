package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
