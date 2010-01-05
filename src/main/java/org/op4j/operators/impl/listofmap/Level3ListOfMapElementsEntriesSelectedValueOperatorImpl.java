package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> {


    public Level3ListOfMapElementsEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> endOn() {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
