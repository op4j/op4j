package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapElementsEntriesSelectedOperator<K,V> {


    public Level2ListOfMapElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2ListOfMapElementsEntriesOperator<K,V> endIf() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
