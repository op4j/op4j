package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfArrayEntriesSelectedOperator<K,V,I> {


    public Level1MapOfArrayEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesOperator<K,V,I> endIf() {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
