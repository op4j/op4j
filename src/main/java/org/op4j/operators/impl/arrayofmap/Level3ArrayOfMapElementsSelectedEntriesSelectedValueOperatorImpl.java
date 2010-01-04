package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
