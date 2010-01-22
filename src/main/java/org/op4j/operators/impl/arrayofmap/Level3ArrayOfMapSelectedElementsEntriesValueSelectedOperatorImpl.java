package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> {


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V,I> endIf() {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endIf().createOperation();
    }



}
