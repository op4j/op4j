package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
