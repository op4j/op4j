package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> {


    public Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> endIf() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level3ListOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3ListOfMapSelectedElementsEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level3ListOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
