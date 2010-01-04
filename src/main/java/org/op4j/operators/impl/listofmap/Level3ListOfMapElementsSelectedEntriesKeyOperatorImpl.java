package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> {


    public Level3ListOfMapElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
