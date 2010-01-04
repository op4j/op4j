package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> {


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3SetOfMapElementsEntriesSelectedValueOperator<K,V> endIf() {
        return new Level3SetOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3SetOfMapElementsEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
