package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endOn().get();
    }



}
