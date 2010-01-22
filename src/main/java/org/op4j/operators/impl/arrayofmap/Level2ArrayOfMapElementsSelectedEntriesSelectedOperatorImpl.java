package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> {


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V,I> endIf() {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level3ArrayOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfMapElementsSelectedEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endIf().createOperation();
    }



}
