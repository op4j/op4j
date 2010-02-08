package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> endOn() {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V>[] get() {
        return endOn().get();
    }



}
