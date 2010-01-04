package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesSelectedValueOperator<K,V> {


    public Level3ListOfMapElementsSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
