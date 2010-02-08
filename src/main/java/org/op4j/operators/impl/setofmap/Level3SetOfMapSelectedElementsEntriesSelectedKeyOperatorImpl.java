package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endOn().get();
    }



}
