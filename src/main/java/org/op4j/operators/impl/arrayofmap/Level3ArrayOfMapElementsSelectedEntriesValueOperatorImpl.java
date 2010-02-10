package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V>[] get() {
        return endOn().get();
    }



}
