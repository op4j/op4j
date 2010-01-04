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


public class Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> {


    public Level3ListOfMapSelectedElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
