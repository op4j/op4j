package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> {


    public Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V,I> endIf() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
