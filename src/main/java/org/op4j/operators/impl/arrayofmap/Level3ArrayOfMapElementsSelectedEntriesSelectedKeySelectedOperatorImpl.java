package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> {


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V,I> endIf() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endIf().createOperation();
    }



}
