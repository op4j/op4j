package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> {


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V,I> endIf() {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
