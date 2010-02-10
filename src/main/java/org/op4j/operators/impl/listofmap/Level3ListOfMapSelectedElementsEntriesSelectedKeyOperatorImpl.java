package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> {


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
