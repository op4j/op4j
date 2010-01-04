package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
