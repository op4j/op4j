package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsSelectedEntriesValueOperator<K,V> {


    public Level3SetOfMapSelectedElementsSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
