package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator<K,V,I> {


    public Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeyOperator<K,V,I> endIf() {
        return new Level3ArrayOfMapSelectedElementsEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapSelectedElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endIf().createOperation();
    }



}
