package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> {


    public Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
