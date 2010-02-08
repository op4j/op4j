package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> {


    public Level3SetOfMapElementsEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2SetOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2SetOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endOn().get();
    }



}
