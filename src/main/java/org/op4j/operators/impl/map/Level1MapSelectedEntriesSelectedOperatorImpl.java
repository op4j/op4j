package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapSelectedEntriesSelectedOperator<K,V,I> {


    public Level1MapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> endIf() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }


    public Operation<Map<K,V>,I> createOperation() {
        return endIf().createOperation();
    }



}
