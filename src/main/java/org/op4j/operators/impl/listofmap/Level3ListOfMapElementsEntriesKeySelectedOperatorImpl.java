package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesKeySelectedOperator<K,V> {


    public Level3ListOfMapElementsEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K,V> endIf() {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
