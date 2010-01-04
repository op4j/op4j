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


public class Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> {


    public Level3SetOfMapElementsEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2SetOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
