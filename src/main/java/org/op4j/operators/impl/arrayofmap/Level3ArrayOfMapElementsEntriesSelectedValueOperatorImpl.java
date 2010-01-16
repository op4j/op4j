package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> {


    public Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V>[] get() {
        return endOn().get();
    }



}
