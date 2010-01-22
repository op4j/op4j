package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesKeySelectedOperator<K,V,I> {


    public Level3SetOfMapElementsEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3SetOfMapElementsEntriesKeyOperator<K,V,I> endIf() {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
