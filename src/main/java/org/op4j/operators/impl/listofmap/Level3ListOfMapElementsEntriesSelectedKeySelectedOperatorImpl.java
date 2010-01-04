package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> {


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ListOfMapElementsEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
