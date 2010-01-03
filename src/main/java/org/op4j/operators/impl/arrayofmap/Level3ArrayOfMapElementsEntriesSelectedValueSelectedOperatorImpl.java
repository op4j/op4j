package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> {


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> endIf() {
        return null;
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
