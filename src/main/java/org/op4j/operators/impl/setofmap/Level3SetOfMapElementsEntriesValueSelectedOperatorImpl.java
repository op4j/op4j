package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesValueSelectedOperator<K,V,I> {


    public Level3SetOfMapElementsEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3SetOfMapElementsEntriesValueOperator<K,V,I> endIf() {
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
