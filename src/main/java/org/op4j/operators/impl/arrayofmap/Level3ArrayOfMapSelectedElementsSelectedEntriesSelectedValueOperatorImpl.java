package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
