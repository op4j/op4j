package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapElementsEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesValueSelectedOperator<K,V> {


    public Level3ListOfMapElementsEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level3ListOfMapElementsEntriesValueOperator<K,V> endIf() {
        return null;
    }


    public Level3ListOfMapElementsEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3ListOfMapElementsEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
