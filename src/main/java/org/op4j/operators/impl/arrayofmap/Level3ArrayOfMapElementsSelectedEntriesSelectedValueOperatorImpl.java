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
import org.op4j.target.Target.Normalisation;


public class Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V>[] get() {
        return endOn().get();
    }



}
