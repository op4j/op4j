package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
