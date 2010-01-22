package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V,I> {


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V,I> endIf() {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapElementsEntriesSelectedValueSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapElementsEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
