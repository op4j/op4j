package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> {


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V,I> endIf() {
        return new Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
