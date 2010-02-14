package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> {


    public Level3ListOfMapSelectedElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
