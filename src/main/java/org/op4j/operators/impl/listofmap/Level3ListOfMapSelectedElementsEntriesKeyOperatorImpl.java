package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> {


    public Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
