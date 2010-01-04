package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> {


    public Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
